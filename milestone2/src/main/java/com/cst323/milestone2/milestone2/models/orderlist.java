package com.cst323.milestone2.milestone2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class orderlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long OrderListID;


    // Default constructor
    public orderlist() {}

    // Parameterized constructor
    public orderlist(Long OrderListID) {
        this.OrderListID = OrderListID;
    }

    // Getters and setters
    
    public Long getOrderListID() {
        return OrderListID;
    }

    public void setOrderListID(Long OrderListID) {
        this.OrderListID = OrderListID;
    }
}
