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
import pl.com.softproject.altkom.hibernate.model.Address;
import pl.com.softproject.altkom.hibernate.model.Form;
import pl.com.softproject.altkom.hibernate.model.FormData;
import pl.com.softproject.altkom.hibernate.model.FormField;
import pl.com.softproject.altkom.hibernate.model.FormFieldValue;
import pl.com.softproject.altkom.hibernate.model.FormFormFieldAssociacion;
import pl.com.softproject.altkom.hibernate.model.Person;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
@ContextConfiguration("/applicationContext.xml")
@TransactionConfiguration(defaultRollback = false)
public class FormDataDAOImplTest extends AbstractTransactionalJUnit4SpringContextTests {
    
    @Autowired
    FormDataDAO formDataDAO;
    
    @Autowired
    FormDAO formDAO;
    
    @Autowired
    PersonDAO personDAO;

    @Test
    public void findByPersonId() {
        Iterable<FormData> res = formDataDAO.findByPersonId(1L);
        
        System.out.println(res);
    }
    
    /**
     * Test of load method, of class FormDataDAOImpl.
     */
    @Test
    public void testLoad() {
    }

    /**
     * Test of save method, of class FormDataDAOImpl.
     */
    @Test
    public void testSave() {
        
        long formId = 1L;
        
        Person p = new Person();
        Address adr = new Address();
        adr.setCiti("C");
        adr.setContry("Poland");
        adr.setPostCode("01-022");
        adr.setStreet("S");
        
        p.setName("Adrian");
        p.setAddress(adr);
        
        personDAO.save(p);
        
        
        Form form = formDAO.load(formId);
        
        FormData formData = new FormData();
        formData.setForm(form);
        formData.setCreationDate(new Date());
        formData.setPerson(p);
        
        for(FormFormFieldAssociacion field : form.getFields()) {
            FormFieldValue value = new FormFieldValue();
            value.setFieldValue(field.getFormField().getQuestion() + " odpowiedź");
            value.setFormData(formData);
            value.setFormField(field.getFormField());
            formData.getAnswers().add(value);
        }
        
        formDataDAO.save(formData);
        
    }
    
}
