/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.com.softproject.altkom.hibernate.dao;

import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import pl.com.softproject.altkom.hibernate.model.FormFieldComboValue;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
@ContextConfiguration("/applicationContext.xml")
@TransactionConfiguration(defaultRollback = false)
public class FormFieldComboValueDAOImplTest extends AbstractTransactionalJUnit4SpringContextTests{
    
    @Autowired
    FormFieldComboValueDAOImpl dao;

    @Test
    public void testSave() {
        dao.save(new FormFieldComboValue("tet", "test"));
    }
    
    @Test
    public void testLoad() {
        FormFieldComboValue res = dao.load(1L);
        System.out.println(res);
    }
    
    @Test
    public void loadAll() {
        Iterable<FormFieldComboValue> res = dao.findAll();
        
        System.out.println(res);
    }
    
}
