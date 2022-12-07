package com.example.ordermanagementsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.ordermanagementsystem.entities.Customer;
import com.example.ordermanagementsystem.entities.Order;

public class CustomerControllerTest extends OrderManagementSystemApplicationTests {

	@Override
	@BeforeEach
	public void setUp() {
		super.setUp();
	}

	@Test
	public void getCustomers() throws Exception {
		String uri = "/api/customers/";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Customer[] customerList = super.mapFromJson(content, Customer[].class);
		assertTrue(customerList.length >= 0);
	}

	@Test
	public void createOrder() throws Exception {
		this.addCustomer();
		String uri = "/api/customers/createorder";
		Order order = new Order();
		order.setOrderName("order1");
		order.setOrderQuantity(10);
		order.setOrderPrice(100);
		order.setCustomerId(1);
		String inputJson = super.mapToJson(order);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		Customer content = super.mapFromJson(mvcResult.getResponse().getContentAsString(), Customer.class);
		assertEquals(content.getCustomerId(), order.getCustomerId());
	}

	@Test
	public void addCustomer() throws Exception {
		String uri = "/api/customers/";
		Customer customer = new Customer();
		customer.setFirstName("Krishna");
		customer.setLastName("Chamoli");
		String inputJson = super.mapToJson(customer);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		Customer content = super.mapFromJson(mvcResult.getResponse().getContentAsString(), Customer.class);
		assertEquals(content.getFirstName(), customer.getFirstName());
		assertEquals(content.getLastName(), customer.getLastName());
	}

}
