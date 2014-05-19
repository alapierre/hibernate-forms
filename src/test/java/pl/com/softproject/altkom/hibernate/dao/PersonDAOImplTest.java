/*
 * Copyright 2014-05-19 the original author or authors.
 */
package pl.com.softproject.altkom.hibernate.dao;

import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import pl.com.softproject.altkom.hibernate.model.Message;
import pl.com.softproject.altkom.hibernate.model.Person;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
@ContextConfiguration("/applicationContext.xml")
@TransactionConfiguration(defaultRollback = false)
public class PersonDAOImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    PersonDAO personDAO;

    /**
     * Test of load method, of class PersonDAOImpl.
     */
    @Test
    public void testLoad() {

        personDAO.load(1L);

    }

    /**
     * Test of save method, of class PersonDAOImpl.
     */
    @Test
    public void testSave() {

        Person p = new Person();
        
        p.setName("imię");

        Message message = new Message();
        message.setContent("treść wiadomości");
        message.setSubject("temat");

        p.addMessage(message);

        personDAO.save(p);

    }

}
