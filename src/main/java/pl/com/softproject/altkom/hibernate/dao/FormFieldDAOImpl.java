/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.com.softproject.altkom.hibernate.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.com.softproject.altkom.hibernate.model.FormField;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
@Repository
public class FormFieldDAOImpl implements FormFieldDAO  {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public FormField load(long id) {
        return (FormField) sessionFactory.getCurrentSession().load(FormField.class, id);
    }
    
    @Override
    public void save(FormField formField) {
        sessionFactory.getCurrentSession().save(formField);
    }
    
}
