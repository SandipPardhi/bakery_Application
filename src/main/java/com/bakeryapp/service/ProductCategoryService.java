package com.bakeryapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bakeryapp.dto.ProductCategoryDto;
import com.bakeryapp.entity.ProductCategory;
import com.bakeryapp.repositoy.ProductCategoryRepository;

@Service
public class ProductCategoryService {

	@Autowired
	private ProductCategoryRepository productCategoryRepository;

	public void addCategory(ProductCategoryDto productCategoryDto) {
		ProductCategory productCategory = new ProductCategory();
		productCategory.setCategory(productCategoryDto.getCategory());
		this.productCategoryRepository.save(productCategory);
	}

	public List<ProductCategory> getAllCategories() {
		return productCategoryRepository.findAll();
	}

	public void updateCategory(Long id, ProductCategoryDto productCategoryDto) {
		ProductCategory existingCategory = productCategoryRepository.findById(id).get();
		existingCategory.setCategory(productCategoryDto.getCategory());
		productCategoryRepository.save(existingCategory);
	}

	public void deleteCategory(Long id) {
		productCategoryRepository.deleteById(id);
	}

}
