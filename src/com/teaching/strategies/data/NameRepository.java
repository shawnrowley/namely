
package com.teaching.strategies.data;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.teaching.strategies.model.Person;

import java.util.List;

@ApplicationScoped
public class NameRepository {

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
        
}
