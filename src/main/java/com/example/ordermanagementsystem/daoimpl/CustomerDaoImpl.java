package com.example.ordermanagementsystem.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ordermanagementsystem.dao.CustomerDao;
import com.example.ordermanagementsystem.entities.Customer;
import com.example.ordermanagementsystem.entities.Order;
import com.example.ordermanagementsystem.repository.CustomerRepository;
import com.example.ordermanagementsystem.repository.OrderRepository;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private CustomerRepository customerRepo;
	@Autowired
	private OrderRepository orderRepo;

	@Override
	public Customer addCustomer(Customer customer) {
		Customer cust = customerRepo.save(customer);
		return cust;
	}

	@Override
	public Order createOrder(Order order) {
		Order ord = orderRepo.save(order);
		return ord;
	}

	@Override
	public List<Customer> getCustomers() {
		List<Customer> customerList = customerRepo.findAll();
		return customerList;
	}

	@Override
	public Customer getCustomer(int customerId) {
		Customer cust = customerRepo.findById(customerId).orElse(null);
		return cust;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Customer cust = customerRepo.save(customer);
		return cust;
	}

	@Override
	public boolean deleteCustomer(int customerId) {
		Customer customer = customerRepo.findById(customerId).orElse(null);
		if (customer == null) {
			return false;
		}
		customerRepo.delete(customer);
		return true;
	}

	@Override
	public List<Customer> getCustomersToNotify() {
		List<Customer> customerList = customerRepo.findAll();
		return customerList;
	}

}
