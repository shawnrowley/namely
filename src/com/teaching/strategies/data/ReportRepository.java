package com.teaching.strategies.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.teaching.strategies.model.Gender;
import com.teaching.strategies.model.Person;
import com.teaching.strategies.model.Report;
import com.teaching.strategies.service.client.GenderAPIClient;

@ApplicationScoped
public class ReportRepository {
	
	@Inject
    private NameRepository repository;

	private List<String> firstNames;
	
	private	GenderAPIClient genderClient;
	
	public ReportRepository() {
		firstNames = new ArrayList<String>();
		genderClient = new GenderAPIClient();
	}
		
	public List<Report> getGenderReport() {
        List<Report> reports = new ArrayList<Report>();
        Set<String> uniqueNames = new HashSet<String>(this.getFirstNames());
    	for (String name : uniqueNames) {
    		Report report = new Report();
        	Gender gen = genderClient.getGenderByName(name);
        	report.setGender(gen.getGender());
        	report.setAccuracy(gen.getAccuracy());
        	report.setName(name);
        	report.setInstances(Collections.frequency(firstNames,name));
        	reports.add(report);
    	}
        return reports;
    }
	
	public List<String> getFirstNames() {
		firstNames.clear();
		for (Person person : repository.getAllOrderedBylastName()) {
			firstNames.add(person.getFirstName());
		}
		return firstNames;
	}
}
