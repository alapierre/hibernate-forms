/*
 * Copyright 2014-05-20 the original author or authors.
 */

package pl.com.softproject.altkom.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
@Entity
@SuppressWarnings("PersistenceUnitPresent")
public class FormFieldValue extends BaseEntity{
    
    @ManyToOne
    @JoinColumn(name = "field_id")
    private FormField formField;
    
    private String fieldValue;
    
    @ManyToOne
    @JoinColumn(name = "formdata_id")
    private FormData formData;

    public FormField getFormField() {
        return formField;
    }

    public void setFormField(FormField formField) {
        this.formField = formField;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    public FormData getFormData() {
        return formData;
    }

    public void setFormData(FormData formData) {
        this.formData = formData;
    }

    
}
