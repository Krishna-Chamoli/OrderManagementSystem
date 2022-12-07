package com.example.ordermanagementsystem.serviceimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ordermanagementsystem.dao.CustomerDao;
import com.example.ordermanagementsystem.dto.CustomerDto;
import com.example.ordermanagementsystem.dto.OrderDto;
import com.example.ordermanagementsystem.entities.Customer;
import com.example.ordermanagementsystem.entities.Order;
import com.example.ordermanagementsystem.exceptions.CustomerNotFoundException;
import com.example.ordermanagementsystem.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private CustomerDao customerDao;

	@Override
	public CustomerDto addCustomer(CustomerDto customerDto) {
		Customer customer = this.convertCustomerDtoToCustomerEntity(customerDto);
		customer.setOrderList(new ArrayList<>());
		Customer custEntity = customerDao.addCustomer(customer);
		CustomerDto custDto = this.convertCustomerEntityToCustomerDto(custEntity);
		return custDto;
	}

	@Override
	public CustomerDto createOrder(OrderDto orderDto) throws CustomerNotFoundException {
		Customer cust = customerDao.getCustomer(orderDto.getCustomerId());
		if (cust == null) {
			throw new CustomerNotFoundException();
		} else {
			orderDto.setCustDto(this.getCustomer(orderDto.getCustomerId()));
		}
		Order order = this.convertOrderDtoToOrderEntity(orderDto);
		if (cust.getOrderList().size() >= 20) {
			double discount = (20.0d / 100.0d) * (order.getOrderPrice());

			order.setOrderDiscount(discount);

			order.setOrderDiscountedPrice(order.getOrderPrice() - discount);

		} else if (cust.getOrderList().size() >= 10) {
			double discount = (10.0d / 100.0d) * (order.getOrderPrice());

			order.setOrderDiscount(discount);

			order.setOrderDiscountedPrice(order.getOrderPrice() - discount);
		} else {
			double discount = 0;
			order.setOrderDiscount(discount);
			order.setOrderDiscountedPrice(order.getOrderPrice() - discount);
		}

		Order orderEntity = customerDao.createOrder(order);
		Customer customer = customerDao.getCustomer(orderEntity.getCust().getCustomerId());
		if (customer.getOrderList().size() >= 19) {
			customer.setCustomerCategory("platinum");
		} else if (customer.getOrderList().size() >= 9) {
			customer.setCustomerCategory("gold");
		} else {
			customer.setCustomerCategory("general");
		}
		CustomerDto custDto = this.convertCustomerEntityToCustomerDto(customerDao.updateCustomer(customer));
		return custDto;
	}

	@Override
	public List<CustomerDto> getCustomers() {
		List<CustomerDto> custDtoList = customerDao.getCustomers().stream()
				.map(this::convertCustomerEntityToCustomerDto).collect(Collectors.toList());
		return custDtoList;
	}

	@Override
	public CustomerDto getCustomer(int customerId) throws CustomerNotFoundException {
		Customer custEntity = customerDao.getCustomer(customerId);
		if (custEntity == null) {
			throw new CustomerNotFoundException();
		}
		CustomerDto custDto = this.convertCustomerEntityToCustomerDto(custEntity);
		return custDto;
	}

	@Override
	public CustomerDto updateCustomer(CustomerDto customerDto) throws CustomerNotFoundException {
		Customer cust = customerDao.getCustomer(customerDto.getCustomerId());
		if (cust == null) {
			throw new CustomerNotFoundException();
		}
		Customer customer = this.convertCustomerDtoToCustomerEntity(customerDto);
		customer.setCustomerCategory(cust.getCustomerCategory());
		customer.setOrderList(cust.getOrderList());
		Customer custEntity = customerDao.addCustomer(customer);
		CustomerDto custDto = this.convertCustomerEntityToCustomerDto(custEntity);
		return custDto;
	}

	@Override
	public Map<String, String> deleteCustomer(int customerId) throws CustomerNotFoundException {
		boolean isDeleted = customerDao.deleteCustomer(customerId);
		Map<String, String> response = new HashMap<>();
		if (isDeleted) {
			response.put("Deleted", "Yes");
			return response;
		} else {
			throw new CustomerNotFoundException();

		}
	}

	private CustomerDto convertCustomerEntityToCustomerDto(Customer customer) {
		CustomerDto customerDto = modelMapper.map(customer, CustomerDto.class);
		return customerDto;
	}

	private Customer convertCustomerDtoToCustomerEntity(CustomerDto customerDto) {

		Customer customer = modelMapper.map(customerDto, Customer.class);
		return customer;

	}

	private Order convertOrderDtoToOrderEntity(OrderDto orderDto) {
		Order order = modelMapper.map(orderDto, Order.class);
		return order;
	}

	@Override
	public List<String> getCustomersNameToNotify() {
		List<Customer> customerList = customerDao.getCustomersToNotify().stream()
				.filter(customer -> customer.getOrderList().size() == 9 || customer.getOrderList().size() == 19)
				.collect(Collectors.toList());

		List<String> customerNameList = new ArrayList<>();
		for (Customer cust : customerList) {
			customerNameList.add(cust.getFirstName() + " " + cust.getLastName());
		}
		return customerNameList;
	}

}
