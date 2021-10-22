package com.example.drugstore.entity;

import lombok.Data;


import javax.persistence.*;

@Data
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeID")
    private Long employeeID;

    @Column(name = "esurname")
    private String esurname;

    @Column(name = "ename")
    private String ename;

    @Column(name = "efathername")
    private String efathername;

    @Column(name = "eposition")
    private String eposition;

    @Column(name = "ebirtday")
    private String ebirtday;

    @Column(name = "ephonenumber")
    private String ephonenumber;

    @Column(name = "esalary")
    private String esalary;
}

