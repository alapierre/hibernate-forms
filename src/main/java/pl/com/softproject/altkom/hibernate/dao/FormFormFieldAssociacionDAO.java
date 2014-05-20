/*
 * Copyright 2014-05-20 the original author or authors.
 */

package pl.com.softproject.altkom.hibernate.dao;

import pl.com.softproject.altkom.hibernate.model.FormFormFieldAssociacion;
import pl.com.softproject.altkom.hibernate.model.composite.FormFormFieldAssociacionId;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public interface FormFormFieldAssociacionDAO {
    
    void delete(FormFormFieldAssociacion entity);

    Iterable<FormFormFieldAssociacion> findAll();

    FormFormFieldAssociacion findOne(FormFormFieldAssociacionId id);

    FormFormFieldAssociacion load(FormFormFieldAssociacionId id);

    void save(FormFormFieldAssociacion entity);
    
    
}
