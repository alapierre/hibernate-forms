/*
 * Copyright 2014-05-20 the original author or authors.
 */

package pl.com.softproject.altkom.hibernate.model;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
@Entity
@SuppressWarnings("PersistenceUnitPresent")
@NamedQuery(name = "formData.findByPersonId", query = "select f from FormData as f  where f.person.id = :personId")
public class FormData extends BaseEntity {
    
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    
    @OneToMany(mappedBy = "formData", cascade = CascadeType.ALL)
    private Set<FormFieldValue> answers = new LinkedHashSet<>();

    @ManyToOne
    @JoinColumn(name = "form_id")
    private Form form;
    
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Set<FormFieldValue> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<FormFieldValue> answers) {
        this.answers = answers;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }
    
}
