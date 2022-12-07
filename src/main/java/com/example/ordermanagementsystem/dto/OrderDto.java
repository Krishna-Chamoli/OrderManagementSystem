package com.example.ordermanagementsystem.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class OrderDto {
	private int orderId;

	private String orderName;

	private int orderQuantity;

	private double orderPrice;

	private int customerId;

	@JsonIgnore
	private CustomerDto custDto;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int cutomerId) {
		this.customerId = cutomerId;
	}

	public CustomerDto getCustDto() {
		return custDto;
	}

	public void setCustDto(CustomerDto custDto) {
		this.custDto = custDto;
	}

}
