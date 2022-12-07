package com.example.ordermanagementsystem.dao;

import java.util.List;

import com.example.ordermanagementsystem.entities.Customer;
import com.example.ordermanagementsystem.entities.Order;

public interface CustomerDao {

	public Customer addCustomer(Customer customer);

	public Order createOrder(Order order);

	public List<Customer> getCustomers();

	public Customer getCustomer(int customerId);

	public Customer updateCustomer(Customer customer);

	public boolean deleteCustomer(int customerId);

	public List<Customer> getCustomersToNotify();
}
