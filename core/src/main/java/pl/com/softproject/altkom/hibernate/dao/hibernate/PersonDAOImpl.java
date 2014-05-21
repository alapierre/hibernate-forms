/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.softproject.altkom.hibernate.dao.hibernate;

import java.util.List;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Repository;
import pl.com.softproject.altkom.hibernate.model.Person;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
@Repository
public class PersonDAOImpl extends GenericDAOHibernateImpl<Person, Long> implements PersonDAO {

    @Override
    public List<Person> findByExample(Person example) {
        return getSession().createCriteria(Person.class)
                .add(Example.create(example)
                        .enableLike()
                        .excludeZeroes()
                        .ignoreCase()
                )
                .list();
    }
    
}
