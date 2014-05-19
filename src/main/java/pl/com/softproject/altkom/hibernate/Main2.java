/*
 * Copyright 2014-05-18 the original author or authors.
 */
package pl.com.softproject.altkom.hibernate;

import java.util.ArrayList;
import org.hibernate.Session;
import pl.com.softproject.altkom.hibernate.dao.MessageDAOImpl;
import pl.com.softproject.altkom.hibernate.dao.PersonDAOImpl;
import pl.com.softproject.altkom.hibernate.dao.TeamDAOImpl;
import pl.com.softproject.altkom.hibernate.model.Message;
import pl.com.softproject.altkom.hibernate.model.Person;
import pl.com.softproject.altkom.hibernate.model.Team;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public class Main2 {

    public static void main(String[] args) {
        System.out.println("start");

        try {

            Session session = HibernateUtil.getSessionFactory().getCurrentSession();

            session.beginTransaction();

            PersonDAOImpl personDAO = new PersonDAOImpl();
            TeamDAOImpl teamDAO = new TeamDAOImpl();
            MessageDAOImpl messageDAO = new MessageDAOImpl();
            
            Person person = personDAO.load(14L);
            
            System.out.println(person.getMessages());
            
            person.getMessages().clear();
           
            
            personDAO.save(person);
            
            
            System.out.println("end");

        } finally {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
            HibernateUtil.getSessionFactory().close();
        }

        
    }

}
