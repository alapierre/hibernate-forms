/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.com.softproject.altkom.hibernate.dao.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.com.softproject.altkom.hibernate.model.FormData;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
@Repository
public class FormDataDAOImpl extends GenericDAOHibernateImpl<FormData, Long> implements FormDataDAO {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public FormData load(long id) {
        return (FormData) sessionFactory.getCurrentSession().load(FormData.class, id);
    }
    
    @Override
    public void save(FormData formData) {
        sessionFactory.getCurrentSession().save(formData);
    }
    
    @Override
    public Iterable<FormData> findByPersonId(long personId) {
        
        return getSession().getNamedQuery("formData.findByPersonId")
                .setLong("personId", personId)
                .list();
        
//        return getSession().createQuery("select f from FormData as f "
//                + " where f.person.id = :personId")
//                .setLong("personId", personId)
//                .list();
    }
    
}
