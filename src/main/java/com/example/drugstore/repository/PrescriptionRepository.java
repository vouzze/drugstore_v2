package com.example.drugstore.repository;

import com.example.drugstore.entity.Prescription;
import org.springframework.data.repository.CrudRepository;

public interface PrescriptionRepository extends CrudRepository<Prescription, Long> {
}
