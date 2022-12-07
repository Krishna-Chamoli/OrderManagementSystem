package com.example.ordermanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ordermanagementsystem.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
