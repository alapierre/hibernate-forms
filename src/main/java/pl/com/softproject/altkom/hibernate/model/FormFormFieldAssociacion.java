/*
 * Copyright 2014-05-20 the original author or authors.
 */

package pl.com.softproject.altkom.hibernate.model;

import java.io.Serializable;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import pl.com.softproject.altkom.hibernate.model.composite.FormFormFieldAssociacionId;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
@Entity
@Table(name = "form_formfields")
@AssociationOverrides({
    @AssociationOverride(name = "id.formField",
            joinColumns = @JoinColumn(name = "formfield_id")),
    @AssociationOverride(name = "id.form",
            joinColumns = @JoinColumn(name = "form_id"))})
@SuppressWarnings("PersistenceUnitPresent")
public class FormFormFieldAssociacion implements Serializable {
    
    @EmbeddedId
    private FormFormFieldAssociacionId id = new FormFormFieldAssociacionId();
    
    private int lp;
    
    private String description;

    public void setForm(Form form) {
        id.setForm(form);
    }
    
    public void setFormField(FormField formField) {
        id.setFormField(formField);
    }
    
    public Form getForm() {
        return id.getForm();
    }
    
    public FormField getFormField() {
        return id.getFormField();
    }
    
    public FormFormFieldAssociacionId getId() {
        return id;
    }

    public void setId(FormFormFieldAssociacionId id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLp() {
        return lp;
    }

    public void setLp(int lp) {
        this.lp = lp;
    }
    
}
