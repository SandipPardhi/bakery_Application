package com.bakeryapp.dto;

public class ProductCategoryDto {

	private Long id;

	private String category;

	public ProductCategoryDto() {
	}

	public ProductCategoryDto(Long id, String category) {
		this.id = id;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
