/*
 * Copyright 2014-05-20 the original author or authors.
 */

package pl.com.softproject.altkom.hibernate.model;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
@Entity
@SuppressWarnings("PersistenceUnitPresent")
public class Form extends BaseEntity {
    
    private String title;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    
    @ManyToMany
    @JoinTable(name = "form_formfields")
    private Set<FormField> fields = new LinkedHashSet<>();

    public void addField(FormField formField) {
        fields.add(formField);
        formField.getForms().add(this);
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Set<FormField> getFields() {
        return fields;
    }

    public void setFields(Set<FormField> fields) {
        this.fields = fields;
    }
    
    
    
}
