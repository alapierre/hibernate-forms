/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.com.softproject.altkom.hibernate.forms.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.com.softproject.altkom.hibernate.model.Form;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
@Controller
@RequestMapping("/admin")
public class FormCreateController {
    
    @RequestMapping("/addForm")
    public ModelAndView prepareHTMLForm() {
        ModelAndView model = new ModelAndView("addForm");
        model.addObject("form", new Form());
        return model;
    }
    
}
