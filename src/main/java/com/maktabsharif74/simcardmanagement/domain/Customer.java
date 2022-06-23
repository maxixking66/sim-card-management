package com.maktabsharif74.simcardmanagement.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Customer extends User {

    public static final String CODE = "code";
    public static final String FAMILIARITY_METHOD_ID = "familiarity_method_id";

    @ManyToOne
    @JoinColumn(name = FAMILIARITY_METHOD_ID)
    private FamiliarityMethod familiarityMethod;

    @Column(name = CODE, unique = true)
    private String code;

    public String test;

    public Customer() {
    }

    public FamiliarityMethod getFamiliarityMethod() {
        return familiarityMethod;
    }

    public void setFamiliarityMethod(FamiliarityMethod familiarityMethod) {
        this.familiarityMethod = familiarityMethod;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + getId() + '\'' + "," +
                "createDate='" + getCreateDate() + '\'' + "," +
                "code='" + code + '\'' +
                '}';
    }
}
