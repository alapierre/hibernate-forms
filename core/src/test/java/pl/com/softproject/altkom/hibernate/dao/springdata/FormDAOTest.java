/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.com.softproject.altkom.hibernate.dao.springdata;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import pl.com.softproject.altkom.hibernate.model.Address;
import pl.com.softproject.altkom.hibernate.model.FieldType;
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
public class FormDAOTest extends AbstractTransactionalJUnit4SpringContextTests  {
    
    @Autowired
    FormDataDAO formDataDAO;
    
    @Autowired
    FormDAO formDAO;
    
    @Autowired
    FormFieldDAO formFieldDAO;
    
    @Autowired
    FormFormFieldAssociacionDAO formFormFieldAssociacionDAO;
    
    @Autowired
    PersonDAO personDAO;

    @Test
    public void testSave() {
        
        List<FormField> fields = new ArrayList<>();
        
        fields.add(new FormField("Kiedy będzeie przerwa?", true));
        fields.add(new FormField("Co jest na obiad?", true));
        
        createForm("Ankieta szkoleniowa", fields);
    }
    
    @Test
    public void testCreateFormDataByForm() {
        
        List<FormField> fields = new ArrayList<FormField>() {{
            add(new FormField("Kiedy będzeie przerwa?", true));
            add(new FormField("Co jest na obiad?", true));
        }};
        
        Form form = createForm("Ankieta szkoleniowa", fields);
        
        Person person = createPerson();
        
        createFormData(form, person);
    }

    private void createFormData(Form form, Person person) {
        FormData formData = new FormData();
        formData.setForm(form);
        formData.setCreationDate(new Date());
        formData.setPerson(person);
        
        for(FormFormFieldAssociacion field : form.getFields()) {
            FormFieldValue value = new FormFieldValue();
            value.setFieldValue(field.getFormField().getQuestion() + " odpowiedź");
            value.setFormData(formData);
            value.setFormField(field.getFormField());
            formData.getAnswers().add(value);
        }
        
        formDataDAO.save(formData);
    }
    
    private Person createPerson() {
        Person p = new Person();
        Address adr = new Address();
        adr.setCiti("C");
        adr.setContry("Poland");
        adr.setPostCode("01-022");
        adr.setStreet("S");
        
        p.setName("Adrian");
        p.setAddress(adr);
        
        personDAO.save(p);
        
        return p;
    }

    private Form createForm(String formName, List<FormField> fields) {
        
        Form form = new Form();
        form.setCreateDate(new Date());
        form.setTitle(formName);
        
        int lp = 1;
        
        formDAO.save(form);
        
        for(FormField field : fields) {
            FormFormFieldAssociacion asoc = new FormFormFieldAssociacion();
            asoc.setForm(form);
            asoc.setFormField(field);
            asoc.setLp(lp++);
            asoc.setDescription("");
            field.getForms().add(asoc);
            form.addField(asoc);
            
            formFieldDAO.save(field);
            formFormFieldAssociacionDAO.save(asoc);
        }
        
        return form;
    }
    
    @Test
    public void testFormFields() {
        Iterable<FormField> res = formFieldDAO.findNotInForm(1L);
        
        System.out.println(res);
    }
    
}
