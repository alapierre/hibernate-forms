/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.com.softproject.altkom.hibernate.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.com.softproject.altkom.hibernate.model.Message;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
@Repository
public class MessageDAOImpl implements MessageDAO {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public Message load(Long id) {
        
        final Message mssagee = (Message) sessionFactory.getCurrentSession().get(Message.class, id);
        return mssagee;
    }
    

    @Override
    public void save(Message person) {
        sessionFactory.getCurrentSession().save(person);
    }
    
}
