/*
 * Copyright 2014-05-20 the original author or authors.
 */

package pl.com.softproject.altkom.hibernate.model.composite;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import pl.com.softproject.altkom.hibernate.model.Form;
import pl.com.softproject.altkom.hibernate.model.FormField;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
@Embeddable
public class FormFormFieldAssociacionId implements Serializable {
    
    @ManyToOne
    private Form form;
    
    @ManyToOne
    private FormField formField;

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public FormField getFormField() {
        return formField;
    }

    public void setFormField(FormField formField) {
        this.formField = formField;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.form);
        hash = 23 * hash + Objects.hashCode(this.formField);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FormFormFieldAssociacionId other = (FormFormFieldAssociacionId) obj;
        if (!Objects.equals(this.form, other.form)) {
            return false;
        }
        if (!Objects.equals(this.formField, other.formField)) {
            return false;
        }
        return true;
    }
    
    
}
