package com.example.ordermanagementsystem.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "order_entity")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;

	private String orderName;

	private int orderQuantity;

	private double orderDiscount;

	private double orderPrice;

	private double orderDiscountedPrice;

	private int customerId;

	@ManyToOne
	private Customer cust;

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

	public double getOrderDiscount() {
		return orderDiscount;
	}

	public void setOrderDiscount(double orderDiscount) {
		this.orderDiscount = orderDiscount;
	}

	public double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}

	public double getOrderDiscountedPrice() {
		return orderDiscountedPrice;
	}

	public void setOrderDiscountedPrice(double orderDiscountedPrice) {
		this.orderDiscountedPrice = orderDiscountedPrice;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderName=" + orderName + ", orderQuantity=" + orderQuantity
				+ ", orderDiscount=" + orderDiscount + ", orderPrice=" + orderPrice + ", orderDiscountedPrice="
				+ orderDiscountedPrice + ", customerId=" + customerId + ", cust=" + cust + "]";
	}

}
