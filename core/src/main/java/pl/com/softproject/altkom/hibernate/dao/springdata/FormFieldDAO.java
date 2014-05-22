/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.com.softproject.altkom.hibernate.dao.springdata;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.com.softproject.altkom.hibernate.model.FormField;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public interface FormFieldDAO extends CrudRepository<FormField, Long>{
    
    @Query(value = "select f from FormField f where f.id "
            + "not in (select a.id.formField.id from FormFormFieldAssociacion a where a.id.form.id = ?)")
    public Iterable<FormField> findNotInForm(long formId);
    
}
