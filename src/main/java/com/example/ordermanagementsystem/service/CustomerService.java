package com.example.ordermanagementsystem.service;

import java.util.List;
import java.util.Map;

import com.example.ordermanagementsystem.dto.CustomerDto;
import com.example.ordermanagementsystem.dto.OrderDto;
import com.example.ordermanagementsystem.exceptions.CustomerNotFoundException;

public interface CustomerService {

	public CustomerDto addCustomer(CustomerDto customerDto);

	public CustomerDto createOrder(OrderDto orderDto) throws CustomerNotFoundException;

	public List<CustomerDto> getCustomers();

	public CustomerDto getCustomer(int customerId) throws CustomerNotFoundException;

	public CustomerDto updateCustomer(CustomerDto customerDto) throws CustomerNotFoundException;

	public Map<String, String> deleteCustomer(int customerId) throws CustomerNotFoundException;

	public List<String> getCustomersNameToNotify();
}
