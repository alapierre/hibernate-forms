/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.com.softproject.altkom.hibernate.forms.web.controller;

import java.util.Date;
import java.util.Enumeration;
import javax.servlet.ServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.com.softproject.altkom.hibernate.dao.springdata.FormDAO;
import pl.com.softproject.altkom.hibernate.dao.springdata.FormDataDAO;
import pl.com.softproject.altkom.hibernate.dao.springdata.PersonDAO;
import pl.com.softproject.altkom.hibernate.model.Address;
import pl.com.softproject.altkom.hibernate.model.Form;
import pl.com.softproject.altkom.hibernate.model.FormData;
import pl.com.softproject.altkom.hibernate.model.FormField;
import pl.com.softproject.altkom.hibernate.model.FormFieldValue;
import pl.com.softproject.altkom.hibernate.model.Person;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
@Controller
public class FormControler {
    
    private Logger logger = Logger.getLogger(getClass());
    
    @Autowired
    FormDAO formDAO;
    
    @Autowired
    PersonDAO personDAO;
    
    @Autowired
    FormDataDAO formDataDAO;
    
    @RequestMapping("/showForms")
    public ModelAndView showForms() {
        
        Iterable<Form> forms = formDAO.findAll();
        ModelAndView model = new ModelAndView("showForms");
        model.addObject("forms", forms);
        
        System.out.println("");
        
        return model;
    }
    
    @RequestMapping("/displayForm")
    public ModelAndView displayForm(@RequestParam long id) {
        
        Form form = formDAO.findOne(id);
        
        ModelAndView model = new ModelAndView("displayForm");
        model.addObject("form", form);
        
        return model;
                
    }
    
    @RequestMapping(value = "/saveFormDate", method = RequestMethod.POST)
    public String saveFormDate(ServletRequest request, @RequestParam("form_id") long formId) {
        
        Person person = new Person();
        
        person.setName(request.getParameter("person.name"));
        person.setAddress(new Address(
                request.getParameter("person.address.citi"),
                request.getParameter("person.address.street"),
                request.getParameter("person.address.postcode")));
        
        personDAO.save(person);
        Form form = formDAO.findOne(formId);
        
        FormData formData = new FormData();
        formData.setForm(form);
        formData.setCreationDate(new Date());
        formData.setPerson(person);
        
        Enumeration<String> params = request.getParameterNames();
        
        while( params.hasMoreElements()) {
            String param = params.nextElement();
            
            if(logger.isDebugEnabled())
                logger.debug(param);
            
            if(param.startsWith("field_")) {
                long fieldId = Long.parseLong(param.replaceFirst("field_", ""));
                
                FormFieldValue value = new FormFieldValue();
                value.setFieldValue(request.getParameter(param));
                value.setFormData(formData);
                value.setFormField(new FormField(fieldId));
                formData.getAnswers().add(value);
            }
        }
        
        formDataDAO.save(formData);
        
        return "redirect:/showForms.htm";
    }
    
}
