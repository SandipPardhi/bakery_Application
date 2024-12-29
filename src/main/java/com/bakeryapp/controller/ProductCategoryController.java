package com.bakeryapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bakeryapp.dto.ProductCategoryDto;
import com.bakeryapp.entity.ProductCategory;
import com.bakeryapp.service.ProductCategoryService;

@RestController
@RequestMapping("/api/categories")
public class ProductCategoryController {

	@Autowired
	private ProductCategoryService productCategoryService;

	@PostMapping
	public ResponseEntity<String> addCategory(@RequestBody ProductCategoryDto productCategoryDto) {
		productCategoryService.addCategory(productCategoryDto);
		return ResponseEntity.ok("Category added successfully!");
	}

	@GetMapping
	public ResponseEntity<List<ProductCategory>> getAllCategories() {
		return ResponseEntity.ok(productCategoryService.getAllCategories());
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateCategory(@PathVariable Long id, @RequestBody ProductCategoryDto categoryDto) {
		productCategoryService.updateCategory(id, categoryDto);
		return ResponseEntity.ok("Category updated successfully!");
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
		productCategoryService.deleteCategory(id);
		return ResponseEntity.ok("Category deleted successfully!");
	}
}
