package com.bakeryapp.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String customerName;

	private String contactNo;

	@OneToMany(mappedBy = "bill")
	private List<Order> order;

	private Double totalAmount;

	private Double discountPercent;

	private Double finalAmount;

	public Bill() {
	}

	public Bill(Long id, String customerName, String contactNo, List<Order> order, Double totalAmount,
			Double discountPercent, Double finalAmount) {
		this.id = id;
		this.customerName = customerName;
		this.contactNo = contactNo;
		this.order = order;
		this.totalAmount = totalAmount;
		this.discountPercent = discountPercent;
		this.finalAmount = finalAmount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public List<Order> getOrderItem() {
		return order;
	}

	public void setOrderItem(List<Order> order) {
		this.order = order;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Double getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(Double discountPercent) {
		this.discountPercent = discountPercent;
	}

	public Double getFinalAmount() {
		return finalAmount;
	}

	public void setFinalAmount(Double finalAmount) {
		this.finalAmount = finalAmount;
	}

}
