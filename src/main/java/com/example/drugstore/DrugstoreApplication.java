package com.example.drugstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages= {"com.example.drugstore.controller"})
@EntityScan("com.example.drugstore.entity")
public class DrugstoreApplication extends ServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(DrugstoreApplication.class, args);
    }

}
