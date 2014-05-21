/*
 * Copyright 2014-05-19 the original author or authors.
 */

package pl.com.softproject.altkom.hibernate.dao.hibernate;

import java.util.List;
import pl.com.softproject.altkom.hibernate.model.Person;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public interface PersonDAO {

    Person load(Long id);

    void save(Person person);

    List<Person> findByExample(Person example);
    
}
