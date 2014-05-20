/*
 * Copyright 2014-05-20 the original author or authors.
 */

package pl.com.softproject.altkom.hibernate.dao.hibernate;

import java.io.Serializable;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 * @param <T>
 * @param <PK>
 */
public interface GenericDAOHibernate<T, PK extends Serializable> {

    void delete(T entity);

    Iterable<T> findAll();

    T findOne(PK id);

    T load(PK id);

    void save(T entity);
    
}
