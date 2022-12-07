package com.example.ordermanagementsystem.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;

	private String firstName;

	private String lastName;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "cust", cascade = CascadeType.REMOVE)
	private List<Order> orderList = new ArrayList<>();

	private String customerCategory = "general";

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	public String getCustomerCategory() {
		return customerCategory;
	}

	public void setCustomerCategory(String customerCategory) {
		this.customerCategory = customerCategory;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", orderList=" + orderList + ", customerCategory=" + customerCategory + "]";
	}

}
