package com.example.drugstore.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "medicines")
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicineID")
    private Long medicineID;

    @Column(name = "mtitle")
    private String mtitle;

    @Column(name = "msize")
    private String msize;

    @Column(name = "mmeasure")
    private String mmeasure;

    @Column(name = "mpurchasePrice")
    private String mpurchasePrice;

    @Column(name = "msellingPrice")
    private String msellingPrice;

    @Column(name = "mprescriptionIsNeeded")
    private String mprescriptionIsNeeded;
}
