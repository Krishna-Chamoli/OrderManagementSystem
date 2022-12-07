package com.example.ordermanagementsystem.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ordermanagementsystem.dto.CustomerDto;
import com.example.ordermanagementsystem.dto.OrderDto;
import com.example.ordermanagementsystem.exceptions.CustomerNotFoundException;
import com.example.ordermanagementsystem.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@PostMapping("/")
	public ResponseEntity<CustomerDto> addCustomer(@RequestBody CustomerDto customerDto) {

		CustomerDto custDto = customerService.addCustomer(customerDto);
		return new ResponseEntity<>(custDto, HttpStatus.CREATED);
	}

	@PostMapping("/createorder")
	public ResponseEntity<CustomerDto> createOrder(@RequestBody OrderDto orderDto) throws CustomerNotFoundException {
		CustomerDto customerDto = customerService.createOrder(orderDto);
		return new ResponseEntity<>(customerDto, HttpStatus.CREATED);
	}

	@GetMapping("/")
	public ResponseEntity<List<CustomerDto>> getCustomers() {
		List<CustomerDto> custDtoList = customerService.getCustomers();
		return new ResponseEntity<>(custDtoList, HttpStatus.OK);
	}

	@GetMapping("/customer")
	public ResponseEntity<CustomerDto> getCustomer(@RequestParam int customerId) throws CustomerNotFoundException {
		CustomerDto custDto = customerService.getCustomer(customerId);
		return new ResponseEntity<>(custDto, HttpStatus.OK);
	}

	@PutMapping("/")
	public ResponseEntity<CustomerDto> updateCustomer(@RequestBody CustomerDto customerDto)
			throws CustomerNotFoundException {
		CustomerDto custDto = customerService.updateCustomer(customerDto);
		return new ResponseEntity<>(custDto, HttpStatus.CREATED);
	}

	@DeleteMapping("/")
	public ResponseEntity<Map<String, String>> deleteCustomer(@RequestParam int customerId)
			throws CustomerNotFoundException {
		Map<String, String> response = customerService.deleteCustomer(customerId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
