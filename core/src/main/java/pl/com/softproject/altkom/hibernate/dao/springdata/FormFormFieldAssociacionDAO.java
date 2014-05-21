/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.com.softproject.altkom.hibernate.dao.springdata;

import org.springframework.data.repository.CrudRepository;
import pl.com.softproject.altkom.hibernate.model.FormFormFieldAssociacion;
import pl.com.softproject.altkom.hibernate.model.composite.FormFormFieldAssociacionId;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public interface FormFormFieldAssociacionDAO extends CrudRepository<FormFormFieldAssociacion, FormFormFieldAssociacionId>{
    
}
