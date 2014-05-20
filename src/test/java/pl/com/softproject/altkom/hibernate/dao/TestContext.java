/*
 * Copyright 2014-05-20 the original author or authors.
 */

package pl.com.softproject.altkom.hibernate.dao;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
@ContextConfiguration("/applicationContext.xml")
@TransactionConfiguration(defaultRollback = false)
public class TestContext extends AbstractTransactionalJUnit4SpringContextTests{
    
    @Test
    public void test() {
        System.out.println("!!!");
    }
    
}
