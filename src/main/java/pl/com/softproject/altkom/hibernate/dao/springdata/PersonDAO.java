/*
 * Copyright 2014-05-20 the original author or authors.
 */

package pl.com.softproject.altkom.hibernate.dao.springdata;

import org.springframework.data.repository.CrudRepository;
import pl.com.softproject.altkom.hibernate.model.Person;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public interface PersonDAO extends CrudRepository<Person, Long>{
    
}
