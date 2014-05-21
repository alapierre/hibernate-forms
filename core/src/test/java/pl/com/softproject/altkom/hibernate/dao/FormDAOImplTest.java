/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.com.softproject.altkom.hibernate.dao;

import java.util.Date;
import java.util.Set;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import pl.com.softproject.altkom.hibernate.model.FieldType;
import pl.com.softproject.altkom.hibernate.model.Form;
import pl.com.softproject.altkom.hibernate.model.FormField;
import pl.com.softproject.altkom.hibernate.model.FormFormFieldAssociacion;

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
    
    @Autowired
    FormFormFieldAssociacionDAO formFormFieldAssociacionDAO;

    /**
     * Test of load method, of class FormDAOImpl.
     */
    @Test
    public void testLoad() {
        
        Form form = formDAO.load(1L);
        
        System.out.println(form.getTitle());
        
        Set<FormFormFieldAssociacion> list = form.getFields();
        
        for(FormFormFieldAssociacion field : list) {
            System.out.println(field.getFormField().getQuestion());
        }
        
        
    }

    /**
     * Test of save method, of class FormDAOImpl.
     */
    @Test
    public void testSave() {
        
        Form form = new Form();
        form.setCreateDate(new Date());
        form.setTitle("Ankieta nr 3");
        
        FormField field1 = new FormField();
        field1.setQuestion("Imię i nazwisko");
        //field1.setDescription("proszę podać imię i nazwisko");
        //field1.setLp(1);
        field1.setRequired(true);
        field1.setFieldType(FieldType.TextField);
        
        FormFormFieldAssociacion asoc = new FormFormFieldAssociacion();
        asoc.setForm(form);
        asoc.setFormField(field1);
        asoc.setLp(1);
        asoc.setDescription("proszę podać imię i nazwisko");
        
        form.addField(asoc);
        field1.getForms().add(asoc);
        
        
        FormField field2 = new FormField();
        field2.setQuestion("Wykształcenie");
        //field2.setDescription("proszę nazwę uczelni");
        //field2.setLp(2);
        field2.setRequired(true);
        field2.setFieldType(FieldType.TextField);
        
        FormFormFieldAssociacion asoc1 = new FormFormFieldAssociacion();
        asoc1.setForm(form);
        asoc1.setLp(2);
        asoc1.setDescription("proszę podać nazwę uczelni");
        asoc1.setFormField(field2);
        form.addField(asoc1);
        field2.getForms().add(asoc1);
        
        formFieldDAO.save(field1);
        formFieldDAO.save(field2);
        formDAO.save(form);
        
        formFormFieldAssociacionDAO.save(asoc);
        formFormFieldAssociacionDAO.save(asoc1);
        
        
    }
    
}
