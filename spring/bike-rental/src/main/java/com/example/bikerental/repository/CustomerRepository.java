package com.example.bikerental.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bikerental.model.CustomerModel;

public interface CustomerRepository extends JpaRepository<CustomerModel,Long>{
    
}
