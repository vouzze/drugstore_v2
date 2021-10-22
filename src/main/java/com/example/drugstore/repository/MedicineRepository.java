package com.example.drugstore.repository;

import com.example.drugstore.entity.Medicine;
import org.springframework.data.repository.CrudRepository;

public interface MedicineRepository extends CrudRepository<Medicine, Long> {
}
