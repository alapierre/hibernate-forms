/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.com.softproject.altkom.hibernate.dao.hibernate;

import org.springframework.stereotype.Repository;
import pl.com.softproject.altkom.hibernate.dao.FormDAO;
import pl.com.softproject.altkom.hibernate.model.Form;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
@Repository
public class FormDAOImpl extends GenericDAOHibernateImpl<Form, Long> implements FormDAO  {
}
