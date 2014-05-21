/*
 * Copyright 2014-05-19 the original author or authors.
 */
package pl.com.softproject.altkom.hibernate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import pl.com.softproject.altkom.hibernate.dao.hibernate.PersonDAO;
import pl.com.softproject.altkom.hibernate.model.Person;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public class Spring {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        TransactionTemplate tx = ctx.getBean(TransactionTemplate.class);

        final PersonDAO personDAO = ctx.getBean(PersonDAO.class);

        tx.execute(new TransactionCallback<Person>() {

            @Override
            public Person doInTransaction(TransactionStatus ts) {
                Person person = personDAO.load(1L);
                
                System.out.println(person);
                
                return person;
            }
        });

        

    }

}
