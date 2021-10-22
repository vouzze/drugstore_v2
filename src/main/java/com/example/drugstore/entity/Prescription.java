package com.example.drugstore.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "prescriptions")
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prescriptionID")
    private Long prescriptionID;

    @Column(name = "pmedicineIDs")
    private String pmedicineIDs;

    @Column(name = "customerID")
    private String customerID;

    @Column(name = "prescriptiondate")
    private String prescriptiondate;
}
