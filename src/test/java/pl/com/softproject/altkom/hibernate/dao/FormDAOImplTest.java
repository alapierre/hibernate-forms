/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.com.softproject.altkom.hibernate.dao;

import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import pl.com.softproject.altkom.hibernate.model.FieldType;
import pl.com.softproject.altkom.hibernate.model.Form;
import pl.com.softproject.altkom.hibernate.model.FormField;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
@ContextConfiguration("/applicationContext.xml")
@TransactionConfiguration(defaultRollback = false)
public class FormDAOImplTest extends AbstractTransactionalJUnit4SpringContextTests {
    
    @Autowired
    FormDAO formDAO;
    
    @Autowired
    FormFieldDAO formFieldDAO;

    /**
     * Test of load method, of class FormDAOImpl.
     */
    @Test
    public void testLoad() {
    }

    /**
     * Test of save method, of class FormDAOImpl.
     */
    @Test
    public void testSave() {
        
        Form form = new Form();
        form.setCreateDate(new Date());
        form.setTitle("Ankieta nr 1");
        
        FormField field1 = new FormField();
        field1.setQuestion("Imię i nazwisko");
        field1.setDescription("proszę podać imię i nazwisko");
        field1.setLp(1);
        field1.setRequired(true);
        field1.setFieldType(FieldType.TextField);
                
        form.addField(field1);
        
        formDAO.save(form);
        formFieldDAO.save(field1);
        
    }
    
}
