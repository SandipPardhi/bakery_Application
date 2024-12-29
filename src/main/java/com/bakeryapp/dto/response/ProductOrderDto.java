package com.bakeryapp.dto.response;

public class ProductOrderDto {

	private String productName;

	private Long quantity;

	private Double price;

	public ProductOrderDto() {
	}

	public ProductOrderDto(String productName, Long quantity, Double price) {
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
