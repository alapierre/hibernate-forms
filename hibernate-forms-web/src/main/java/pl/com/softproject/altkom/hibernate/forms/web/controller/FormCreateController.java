/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.com.softproject.altkom.hibernate.forms.web.controller;

import java.util.Date;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.com.softproject.altkom.hibernate.dao.springdata.FormDAO;
import pl.com.softproject.altkom.hibernate.dao.springdata.FormFieldDAO;
import pl.com.softproject.altkom.hibernate.dao.springdata.FormFormFieldAssociacionDAO;
import pl.com.softproject.altkom.hibernate.model.Form;
import pl.com.softproject.altkom.hibernate.model.FormField;
import pl.com.softproject.altkom.hibernate.model.FormFormFieldAssociacion;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
@Controller
@RequestMapping("/admin")
public class FormCreateController {
    
    @Autowired
    FormDAO formDAO;
    
    @Autowired
    FormFieldDAO formFieldDAO;
    
    @Autowired
    FormFormFieldAssociacionDAO formFormFieldAssociacionDAO;
    
    @RequestMapping("/addForm")
    public ModelAndView prepareHTMLForm() {
        ModelAndView model = new ModelAndView("addForm");
        model.addObject("form", new Form());
        return model;
    }
    
    @RequestMapping(value = "/saveForm", method = RequestMethod.POST)
    public String saveForm(@Valid Form form, BindingResult result) {
        
        if(result.hasErrors()) {
            return "addForm";
        }
        
        form.setCreateDate(new Date());
        formDAO.save(form);
        return "redirect:/showForms.htm";
    }
    
    @RequestMapping("/addFormField")
    public ModelAndView prepareHTMLFormField(@RequestParam("form_id") Long formId) {
        
        ModelAndView model = new ModelAndView("addFormField");
        
        Form form = formDAO.findOne(formId);
        model.addObject("form", form);
        
        final FormFormFieldAssociacion formFormFieldAssociacion = new FormFormFieldAssociacion();
        formFormFieldAssociacion.setForm(form);
        model.addObject("formFormFieldAssociacion", formFormFieldAssociacion);
        
        model.addObject("formFields", formFieldDAO.findNotInForm(formId));
        
        return model;
    }
    
    @RequestMapping(value = "/saveFormField", method = RequestMethod.POST)
    public String saveFormField(FormFormFieldAssociacion formFieldAssociacion) {
        
        formFormFieldAssociacionDAO.save(formFieldAssociacion);
                
        return "redirect:/admin/addFormField.htm?form_id=" + formFieldAssociacion.getForm().getId();
    }
    
}
