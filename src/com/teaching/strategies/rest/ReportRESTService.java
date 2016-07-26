package com.teaching.strategies.rest;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.teaching.strategies.data.ReportRepository;
import com.teaching.strategies.model.Report;

@Path("/report")
public class ReportRESTService {
   
	@Inject
	private ReportRepository repository;
    
	/**
	 * 
	 * Get Reports
	 * 
	 * @return List<Report>
	 */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Report> listAllPersons() {
    	 return repository.getGenderCountryReport();
    }
}