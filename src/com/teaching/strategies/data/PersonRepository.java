
package com.teaching.strategies.data;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.teaching.strategies.model.Person;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PersonRepository {

    @Inject
    private EntityManager em;
    
    /**
     * find Person by id
     * 
     * @param id
     * @return Person
     */
    public Person findById(Long id) {
        return em.find(Person.class, id);
    }

    /**
     * gets all Persons Order by last name
     * 
     * @return  List<Person> list of Persons
     */
    public List<Person> getAllOrderedBylastName() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Person> criteria = cb.createQuery(Person.class);
        Root<Person> Person = criteria.from(Person.class);
        criteria.select(Person).orderBy(cb.asc(Person.get("lastName")));
        return em.createQuery(criteria).getResultList();
    }
    
    /**
     * getCountry by name
     * 
     * @return  List<String> list Countries
     */
    public List<String> getCountry(String name) {
    	CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<String> query = cb.createQuery(String.class);
        Root<Person> person = query.from(Person.class);
        query.select(person.<String>get("country"));
        query.distinct(true);
        query.where(cb.equal(person.<String>get("firstName"),
                    cb.parameter(String.class, "param")));
        TypedQuery<String> tq = em.createQuery(query);
        tq.setParameter("param", name);
        List<String> countries = tq.getResultList();
        return countries;
    }
 
    /**
     * getNameCountByCountry
     * 
     * @return  Long count
     */
    public Long getNameCountByCountry(String name, String country) {
    	CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> query = cb.createQuery(Long.class);
        Root<Person> person = query.from(Person.class);
        query.select(cb.count(person));
        query.distinct(true);
        
        List<Predicate> predicates = new ArrayList<Predicate>();
        predicates.add(cb.equal(person.<String>get("firstName"),
                       cb.parameter(String.class, "paramName")));
        predicates.add(cb.equal(person.<String>get("country"),
                       cb.parameter(String.class, "paramCountry")));
        
        query.where(predicates.toArray(new Predicate[]{}) ); 
        TypedQuery<Long> tq = em.createQuery(query);
        tq.setParameter("paramName", name);
        tq.setParameter("paramCountry", country);
        Long count = tq.getSingleResult();
        return count;
    }
    
    
        
}
