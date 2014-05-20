/*
 * Copyright 2014-05-20 the original author or authors.
 */

package pl.com.softproject.altkom.hibernate.model;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
@Entity
@SuppressWarnings("PersistenceUnitPresent")
public class Form extends BaseEntity {

    public Form() {
    }

    public Form(Long id) {
        super(id);
    }
    
    
    
    private String title;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "form_formfields")
//    @OrderBy("lp")
//    private Set<FormField> fields = new LinkedHashSet<>();

    @OneToMany
    private Set<FormFormFieldAssociacion> fields = new LinkedHashSet<>();;
    
    public void addField(FormFormFieldAssociacion formField) {
        fields.add(formField);
        formField.getId().setForm(this);
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

    public Set<FormFormFieldAssociacion> getFields() {
        return fields;
    }

    public void setFields(Set<FormFormFieldAssociacion> fields) {
        this.fields = fields;
    }
    
}
