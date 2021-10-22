package com.example.drugstore.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderID")
    private Long orderID;

    @Column(name = "omedicineIDs")
    private String omedicineIDs;

    @Column(name = "employeeID")
    private String employeeID;

    @Column(name = "customerID")
    private String customerID;

    @Column(name = "orderdate")
    private String orderdate;
}
