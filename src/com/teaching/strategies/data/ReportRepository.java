package com.teaching.strategies.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
	
	/**
	 * Initializes Gender client and firstNames
	 */
	public ReportRepository() {
		firstNames = new ArrayList<String>();
		genderClient = new GenderAPIClient();
	}
	
	public List<Report> getGenderReport() {
        List<Report> reports = new ArrayList<Report>();
		GenderAPIClient gender = new GenderAPIClient();
          
        Set<String> uniqueSet = new HashSet<String>(this.getFirstNames());
    	for (String name : uniqueSet) {
    		Report report = new Report();
        	Gender gen = gender.getGenderByName(name);
        	report.setGender(gen.getGender());
        	report.setAccuracy(gen.getAccuracy());
        	report.setName(name);
        	report.setInstances(Collections.frequency(firstNames,name));
        	reports.add(report);
    	}
        return reports;
    }
	
	/**
	 * Generates report from first	
	 * 
	 * @return List<Report> list of reports objects
	 */
	public List<Report> getGenderCountryReport() {
        List<Report> reports = new ArrayList<Report>();
        Set<String> uniqueNames = new HashSet<String>(this.getFirstNames());
    	for (String name : uniqueNames) {
    		for (String country : repository.getCountry(name)) {
    			Report report = new Report();
        		Gender gen = genderClient.getGenderByCountry(name, country);
        		report.setGender(gen.getGender());
        		report.setAccuracy(gen.getAccuracy());
        		report.setName(name);
        		report.setCountry(country);
        		//report.setInstances(Collections.frequency(firstNames,name));
        		report.setInstances(repository.getNameCountByCountry(name, country));
        		reports.add(report);
    		}	
    	}
        return reports;
    }
	
	/**
	 * Compiles and list of first names	
	 * 
	 * @return List<String> list of first names
	 */
	public List<String> getFirstNames() {
		firstNames.clear();
		for (Person person : repository.getAllOrderedBylastName()) {
			firstNames.add(person.getFirstName());
		}
		return firstNames;
	}

}
