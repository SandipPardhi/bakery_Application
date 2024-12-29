package com.bakeryapp.dto.response;

import java.util.List;

public class BillDto {

	private Long billId;

	private String customerName;

	private String contactNo;

	private List<ProductOrderDto> orderedProducts;

	private Double totalAmount;

	private Double discountPercent;

	private Double finalAmount;

	public BillDto() {
	}

	public BillDto(Long billId, String customerName, String contactNo, List<ProductOrderDto> orderedProducts,
			Double totalAmount, Double discountPercent, Double finalAmount) {
		this.billId = billId;
		this.customerName = customerName;
		this.contactNo = contactNo;
		this.orderedProducts = orderedProducts;
		this.totalAmount = totalAmount;
		this.discountPercent = discountPercent;
		this.finalAmount = finalAmount;
	}

	public Long getBillId() {
		return billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
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

	public List<ProductOrderDto> getOrderedProducts() {
		return orderedProducts;
	}

	public void setOrderedProducts(List<ProductOrderDto> orderedProducts) {
		this.orderedProducts = orderedProducts;
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
