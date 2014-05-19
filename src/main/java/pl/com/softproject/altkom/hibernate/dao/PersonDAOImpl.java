/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.softproject.altkom.hibernate.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.com.softproject.altkom.hibernate.model.Person;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
@Repository
public class PersonDAOImpl implements PersonDAO {

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public Person load(Long id) {
        
        final Person person = (Person) sessionFactory.getCurrentSession().get(Person.class, id);
        return person;
    }
    

    @Override
    public void save(Person person) {
        sessionFactory.getCurrentSession().save(person);
    }
    
}
