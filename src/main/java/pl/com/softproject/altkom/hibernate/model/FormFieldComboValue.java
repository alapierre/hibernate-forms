/*
 * Copyright 2014-05-20 the original author or authors.
 */

package pl.com.softproject.altkom.hibernate.model;

import javax.persistence.Entity;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
@Entity
@SuppressWarnings("PersistenceUnitPresent")
public class FormFieldComboValue extends BaseEntity {
    
    private String itemLabel;
    private String itemValue;

    public FormFieldComboValue() {
    }

    public FormFieldComboValue(String itemLabel, String itemValue) {
        this.itemLabel = itemLabel;
        this.itemValue = itemValue;
    }
    
    public String getItemLabel() {
        return itemLabel;
    }

    public void setItemLabel(String itemLabel) {
        this.itemLabel = itemLabel;
    }

    public String getItemValue() {
        return itemValue;
    }

    public void setItemValue(String itemValue) {
        this.itemValue = itemValue;
    }
    
    
    
}
