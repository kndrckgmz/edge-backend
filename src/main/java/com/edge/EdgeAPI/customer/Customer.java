package com.edge.EdgeAPI.customer;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Customer {
    
    @Id
    @SequenceGenerator(
        name="customer_sequence",
        sequenceName="customer_sequence",
        allocationSize=1
    )
    @GeneratedValue(
        strategy=GenerationType.SEQUENCE,
        generator="customer_sequence"
    )
    private Long accountId;
    private String name;
    private String email;
    private LocalDate dob;

    public Customer() {
    }

    public Customer(Long accountId, String name, String email, LocalDate dob) {
        this.accountId = accountId;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Customer(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Long getAccountId() {
        return this.accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return this.dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Customer accountId(Long accountId) {
        setAccountId(accountId);
        return this;
    }

    public Customer name(String name) {
        setName(name);
        return this;
    }

    public Customer email(String email) {
        setEmail(email);
        return this;
    }

    public Customer dob(LocalDate dob) {
        setDob(dob);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " accountId='" + getAccountId() + "'" +
            ", name='" + getName() + "'" +
            ", email='" + getEmail() + "'" +
            ", dob='" + getDob() + "'" +
            "}";
    }
    
}

