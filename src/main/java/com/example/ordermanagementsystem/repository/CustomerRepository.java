package com.example.ordermanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ordermanagementsystem.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
