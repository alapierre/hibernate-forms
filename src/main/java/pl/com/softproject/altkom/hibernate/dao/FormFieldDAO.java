/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.com.softproject.altkom.hibernate.dao;

import pl.com.softproject.altkom.hibernate.model.FormField;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public interface FormFieldDAO {

    FormField load(Long id);

    void save(FormField formField);
    
}
