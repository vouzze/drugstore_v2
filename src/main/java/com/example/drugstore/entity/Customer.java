package com.example.drugstore.entity;

import lombok.Data;


import javax.persistence.*;

@Data
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerID")
    private Long customerID;

    @Column(name = "csurname")
    private String csurname;

    @Column(name = "cname")
    private String cname;

    @Column(name = "cfathername")
    private String cfathername;

    @Column(name = "cbirtday")
    private String cbirtday;

    @Column(name = "cstreet")
    private String cstreet;

    @Column(name = "cbuilding")
    private String cbuilding;

    @Column(name = "cappartments")
    private String cappartments;

    @Column(name = "ccity")
    private String ccity;

    @Column(name = "cphonenumber")
    private String cphonenumber;
}
