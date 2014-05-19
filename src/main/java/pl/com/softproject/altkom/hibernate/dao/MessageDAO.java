/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.com.softproject.altkom.hibernate.dao;

import org.hibernate.Session;
import pl.com.softproject.altkom.hibernate.HibernateUtil;
import pl.com.softproject.altkom.hibernate.model.Message;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public class MessageDAO {
    
    private final Session currentSession = HibernateUtil.getSessionFactory().getCurrentSession();
    
    public Message load(Long id) {
        
        final Message mssagee = (Message) currentSession.get(Message.class, id);
        return mssagee;
    }
    

    public void save(Message person) {
        currentSession.save(person);
    }
    
}
