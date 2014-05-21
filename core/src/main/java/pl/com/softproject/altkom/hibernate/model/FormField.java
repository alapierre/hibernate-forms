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
    
    private boolean required;

    @OneToMany(mappedBy = "id.formField")
    private Set<FormFormFieldAssociacion> forms = new HashSet<>();
    
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

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public Set<FormFormFieldAssociacion> getForms() {
        return forms;
    }

    public void setForms(Set<FormFormFieldAssociacion> forms) {
        this.forms = forms;
    }

    public List<FormFieldComboValue> getComboValues() {
        return comboValues;
    }

    public void setComboValues(List<FormFieldComboValue> comboValues) {
        this.comboValues = comboValues;
    }
    
    
    
}
