/*
 * Copyright 2014-05-20 the original author or authors.
 */

package pl.com.softproject.altkom.hibernate.dao.springdata;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.history.Revision;
import org.springframework.data.history.Revisions;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import pl.com.softproject.altkom.hibernate.model.Address;
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
    public void testSave() {
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
    
    @Test
    public void testUpdate() {
        Person p = personDAO.findOne(4L);
        p.setName("nowe imie");
        personDAO.save(p);
    }
    
    @Test
    public void testLoad() {
        
        Person p = personDAO.findOne(1L);
        System.out.println(p);
    }
    
    @Test
    public void testFindByName() {
        
        Iterable<Person> res = personDAO.findByNameLikeIgnoreCase("adrian");
        
        System.out.println(res);
        
    }
    
    @Test
    public void testAudit() {
        Revisions<Integer, Person> revs = personDAO.findRevisions(4L);
        
        for(Revision<Integer, Person> rev :revs) {
            System.out.println(rev);
        }
        
    }
}
