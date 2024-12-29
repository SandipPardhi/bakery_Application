package com.bakeryapp.dto;

public class ProductDto {

	private String productName;

	private String description;

	private double price;

	private Long categoryId;

	public ProductDto() {
	}

	public ProductDto(String productName, String description, double price, Long categoryId) {
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.categoryId = categoryId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

}
