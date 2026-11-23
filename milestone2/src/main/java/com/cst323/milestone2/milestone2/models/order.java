package com.cst323.milestone2.milestone2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long OrderID;
    private int Associated_Customer;
    private int Associated_Order_List;
    private double Total_Price;
    private String Delivery_Address;
    private String Payment_Type;
    private String Date_Placed;

    // Default constructor
    public order() {}

    // Parameterized constructor
    public order(int Associated_Customer, int Associated_Order_List, double Total_Price, String Delivery_Address, String Payment_Type, String Date_Placed) {
        this.Associated_Customer = Associated_Customer;
        this.Associated_Order_List = Associated_Order_List;
        this.Total_Price = Total_Price;
        this.Delivery_Address = Delivery_Address;
        this.Payment_Type = Payment_Type;
        this.Date_Placed = Date_Placed;
    }

    // Getters and setters
    
    public Long getOrderID() {
        return OrderID;
    }

    public void setOrderID(Long OrderID) {
        this.OrderID = OrderID;
    }

    public int getAssociated_Customer() {
        return Associated_Customer;
    }

    public void setAssociated_Customer(int Associated_Customer) {
        this.Associated_Customer = Associated_Customer;
    }

    public int getAssociated_Order_List() {
        return Associated_Order_List;
    }

    public void setAssociated_Order_List(int Associated_Order_List) {
        this.Associated_Order_List = Associated_Order_List;
    }

    public double getTotal_Price() {
        return Total_Price;
    }

    public void setTotal_Price(double Total_Price) {
        this.Total_Price = Total_Price;
    }

    public String getDelivery_Address() {
        return Delivery_Address;
    }

    public void setDelivery_Address(String Delivery_Address) {
        this.Delivery_Address = Delivery_Address;
    }

    public String getPayment_Type() {
        return Payment_Type;
    }

    public void setPayment_Type(String Payment_Type) {
        this.Payment_Type = Payment_Type;
    }

    public String getDate_Placed() {
        return Date_Placed;
    }

    public void setDate_Placed(String Date_Placed) {
        this.Date_Placed = Date_Placed;
    }
}
