package com.bakeryapp.dto.request;

import java.util.Map;

public class OrderDto {

	private String customerName;

	private String contactNo;

	private Map<Long, Long> productWithQuantities;

	private Double discountPrecent;

	public OrderDto() {
	}

	public OrderDto(String customerName, String contactNo, Map<Long, Long> productWithQuantities,
			Double discountPrecent) {
		this.customerName = customerName;
		this.contactNo = contactNo;
		this.productWithQuantities = productWithQuantities;
		this.discountPrecent = discountPrecent;
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

	public Map<Long, Long> getProductWithQuantities() {
		return productWithQuantities;
	}

	public void setProductWithQuantities(Map<Long, Long> productWithQuantities) {
		this.productWithQuantities = productWithQuantities;
	}

	public Double getDiscountPrecent() {
		return discountPrecent;
	}

	public void setDiscountPrecent(Double discountPrecent) {
		this.discountPrecent = discountPrecent;
	}

}
