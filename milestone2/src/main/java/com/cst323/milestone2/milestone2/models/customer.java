package com.cst323.milestone2.milestone2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CustomerID;

    // Default constructor
    public customer() {}

    // Parameterized constructor
    public customer(Long CustomerID) {
        this.CustomerID = CustomerID;
    }

    // Getters and setters

    public Long getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(Long CustomerID) {
        this.CustomerID = CustomerID;
    }
}
