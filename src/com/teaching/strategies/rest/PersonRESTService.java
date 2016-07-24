package com.teaching.strategies.rest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import javax.validation.Validator;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.teaching.strategies.data.NameRepository;
import com.teaching.strategies.model.Person;
import com.teaching.strategies.service.PersonRegistration;
/**
 * 
 * PersonRestService
 * 
 * @author srowley
 *
 */
@Path("/Persons")
@RequestScoped
public class PersonRESTService {

    @Inject
    private Logger log;

    @Inject
    private Validator validator;

    @Inject
    private NameRepository repository;
    
    @Inject
    PersonRegistration registration;

    
    /**
     * Gets list of Persons
     * 
     * @return List<Person>
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAllPersons() {
        return repository.getAllOrderedBylastName();
    }
    
    /**
     *  getPersonByid 
     *  may have future use
     *  
     * @param id
     * @return Person
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPersonById(@PathParam("id") long id) {
        Person person = repository.findById(id);
        if (person == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return person;
    }
    
    /**
     *  Delete Person
     * 
     * @param id
     */
    @DELETE  
    @Path("{id}")  
    @Produces(MediaType.APPLICATION_JSON)  
    public void deletePerson(@PathParam("id") long id)  
    {  
    	Person person = repository.findById(id);
    	if (person == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    	try {
			registration.delete(person);
		} catch (Exception e) {
			e.printStackTrace();
		}  
     }  
      
    /**
     * Update Person
     * 
     * @param person
     * @return Response 
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePerson(Person person) {
    	 Response.ResponseBuilder builder = null;
         try {
             validatePerson(person);
             registration.update(person);
             builder = Response.ok();
         } catch (ValidationException e) {
             Map<String, String> responseObj = new HashMap<>();
             responseObj.put("error", e.getMessage());
             builder = Response.status(Response.Status.CONFLICT).entity(responseObj);
         } catch (Exception e) {
             Map<String, String> responseObj = new HashMap<>();
             responseObj.put("error", e.getMessage());
             builder = Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
         }
         return builder.build();
    }
   
    /**
     * Create Person
     * 
     * @param person
     * @return Response
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPerson(Person person) {

        Response.ResponseBuilder builder = null;
        try {
            validatePerson(person);
            registration.create(person);
            builder = Response.ok();
        } catch (ValidationException e) {
            Map<String, String> responseObj = new HashMap<>();
            responseObj.put("error", e.getMessage());
            builder = Response.status(Response.Status.CONFLICT).entity(responseObj);
        } catch (Exception e) {
            Map<String, String> responseObj = new HashMap<>();
            responseObj.put("error", e.getMessage());
            builder = Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
        }
        return builder.build();
    }
    
    /**
     * Validate Person based persistent constraints
     * 
     * @param Person
     * @throws ConstraintViolationException
     * @throws ValidationException
     */
    private void validatePerson(Person Person) throws ConstraintViolationException, ValidationException {
        Set<ConstraintViolation<Person>> violations = validator.validate(Person);

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(new HashSet<ConstraintViolation<?>>(violations));
        }
    }
   
}
