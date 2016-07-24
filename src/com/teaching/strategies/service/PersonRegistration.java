package com.teaching.strategies.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.teaching.strategies.model.Person;

import java.util.logging.Logger;

@Stateless
public class PersonRegistration {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;


    public void create(Person person) throws Exception {
        log.info("Adding " + person.getFirstName());
        em.persist(person);
    }
        
    public void delete(Person person) throws Exception {
    	log.info("Deleting " + person.getFirstName());
    	Person removed = em.getReference(Person.class, person.getId());
        em.remove(removed);
     }
    
    public Person update(Person person) throws Exception {
    	log.info("Updating " + person.getFirstName());
    	em.merge(person);
    	return person;
    }
    
}
