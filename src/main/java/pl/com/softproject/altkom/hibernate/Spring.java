/*
 * Copyright 2014-05-19 the original author or authors.
 */

package pl.com.softproject.altkom.hibernate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.com.softproject.altkom.hibernate.dao.PersonDAO;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public class Spring {
    
    public static void main(String[] args) {
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    
        PersonDAO personDAO = ctx.getBean(PersonDAO.class);
        
        personDAO.load(1L);
        
    }
    
}
