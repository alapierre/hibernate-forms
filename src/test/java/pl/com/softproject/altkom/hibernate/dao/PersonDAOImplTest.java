/*
 * Copyright 2014-05-19 the original author or authors.
 */
package pl.com.softproject.altkom.hibernate.dao;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import pl.com.softproject.altkom.hibernate.model.Address;
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

    @Test
    public void testFindByCriteria() {
        
//        Person test = new Person();
//        test.setName("Adrian");
//        
//        personDAO.save(test);
        
        Person p = new Person();
        p.setName("adrian");
        
        List<Person> res = personDAO.findByExample(p);
        
        System.out.println(res);
        
    }
    
    @Test
    public void testSaveWithAddress() {
        
        Person p = new Person();
        p.setName("Adrian");
        
        Address address = new Address();
        address.setCiti("Łomianki");
        address.setContry("Poland");
        address.setStreet("Warszawska 109");
        address.setPostCode("05-092");
        p.setAddress(address);
        
        personDAO.save(p);
        
    }
    
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
        
        p.setName("kaksksasajksajksajksajk");

        Message message = new Message();
        message.setContent("treść wiadomości");
        message.setSubject("temat");

        p.addMessage(message);

        personDAO.save(p);

    }

}
