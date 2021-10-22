package com.example.drugstore.repository;

import com.example.drugstore.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
