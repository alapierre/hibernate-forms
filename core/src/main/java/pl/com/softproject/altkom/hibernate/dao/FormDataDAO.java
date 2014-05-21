/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.com.softproject.altkom.hibernate.dao;

import pl.com.softproject.altkom.hibernate.model.FormData;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public interface FormDataDAO {

    FormData load(long id);

    void save(FormData formData);

    Iterable<FormData> findByPersonId(long personId);
    
}
