/*
 * Copyright 2014-05-18 the original author or authors.
 */
package pl.com.softproject.altkom.hibernate;

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
public class Main {

    public static void main(String[] args) {
        System.out.println("start");

        try {

            Session session = HibernateUtil.getSessionFactory().getCurrentSession();

            session.beginTransaction();

            PersonDAOImpl personDAO = new PersonDAOImpl();
            TeamDAOImpl teamDAO = new TeamDAOImpl();
            MessageDAOImpl messageDAO = new MessageDAOImpl();
            
            Team team = teamDAO.load(1L);
            
            Person p = new Person();
            p.setTeam(team);
            p.setName("imię");
            
            Message message = new Message();
            message.setContent("treść wiadomości");
            message.setSubject("temat");
            
            p.addMessage(message);
            
            //personDAO.save(p);
            messageDAO.save(message);
            
            System.out.println("end");

        } finally {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
            HibernateUtil.getSessionFactory().close();
        }

        
    }

}
