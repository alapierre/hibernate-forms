/*
 * Copyright 2014-05-18 the original author or authors.
 */

package pl.com.softproject.altkom.hibernate.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 * @param <T>
 * @param <PK>
 */
public class GenericDAOHibernateImpl<T, PK extends Serializable> implements GenericDAOHibernate<T, PK> {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    private final Class<T> type;
    private final Class<PK> primaryKeyType;
    
    public GenericDAOHibernateImpl() {
        
        this.type = (Class<T>) ((ParameterizedType) getClass()
                            .getGenericSuperclass()).getActualTypeArguments()[0];
        
        this.primaryKeyType = (Class<PK>) ((ParameterizedType) getClass()
                            .getGenericSuperclass()).getActualTypeArguments()[1];;
    }
    
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    
    @Override
    public T findOne(PK id) {
        return load(id);
    }
    
    @Override
    public T load(PK id) {
        return (T) getSession().load(type, id);
    }
    
    @Override
    public void save(T entity) {
        getSession().saveOrUpdate(entity);
    }
    
    @Override
    public Iterable<T> findAll() {
        return getSession().createCriteria(type).list();
    }
    
    @Override
    public void delete(T entity) {
        getSession().delete(entity);
        
    }
}
