/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
public class GenericDAOHibernateImpl<T, PK extends Serializable> {
    
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
    
    public T findOne(PK id) {
        return load(id);
    }
    
    public T load(PK id) {
        return (T) getSession().load(type, id);
    }
    
    public void save(T entity) {
        getSession().saveOrUpdate(entity);
    }
    
    public Iterable<T> findAll() {
        return getSession().createCriteria(type).list();
    }
    
    public void delete(T entity) {
        getSession().delete(entity);
        
    }
}
