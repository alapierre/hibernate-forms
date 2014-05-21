/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.com.softproject.altkom.hibernate.forms.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.com.softproject.altkom.hibernate.dao.springdata.FormDAO;
import pl.com.softproject.altkom.hibernate.model.Form;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
@Controller
public class FormControler {
    
    @Autowired
    FormDAO formDAO;
    
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
    
}
