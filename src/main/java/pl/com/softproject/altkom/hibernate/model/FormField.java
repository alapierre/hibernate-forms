/*
 * Copyright 2014-05-20 the original author or authors.
 */

package pl.com.softproject.altkom.hibernate.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
@Entity
@SuppressWarnings("PersistenceUnitPresent")
public class FormField extends BaseEntity{
    
    @Enumerated(EnumType.STRING)
    private FieldType fieldType;
    
    @NotEmpty
    @Size(max = 1024)
    private String question;
    
    @Size(max = 2048)
    private String description;
    
    @Min(0)
    private int lp;
    
    private boolean required;

    @ManyToMany(mappedBy = "fields", cascade = CascadeType.ALL)
    private Set<Form> forms = new HashSet<>();
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "field_id")
    private List<FormFieldComboValue> comboValues = new ArrayList<>(0);
    
    public FieldType getFieldType() {
        return fieldType;
    }

    public void setFieldType(FieldType fieldType) {
        this.fieldType = fieldType;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
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

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public Set<Form> getForms() {
        return forms;
    }

    public void setForms(Set<Form> forms) {
        this.forms = forms;
    }

    public List<FormFieldComboValue> getComboValues() {
        return comboValues;
    }

    public void setComboValues(List<FormFieldComboValue> comboValues) {
        this.comboValues = comboValues;
    }
    
    
    
}
