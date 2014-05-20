/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.com.softproject.altkom.hibernate.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.com.softproject.altkom.hibernate.model.Form;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
@Repository
public class FormDAOImpl implements FormDAO  {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public Form load(long id) {
        return (Form) sessionFactory.getCurrentSession().load(Form.class, id);
    }
    
    @Override
    public void save(Form form) {
        sessionFactory.getCurrentSession().save(form);
    }
    
}
