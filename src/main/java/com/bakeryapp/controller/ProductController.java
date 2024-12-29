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

import com.bakeryapp.dto.ProductDto;
import com.bakeryapp.entity.Product;
import com.bakeryapp.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping
	public ResponseEntity<String> addProduct(@RequestBody ProductDto productDto) {
		productService.addProduct(productDto);
		return ResponseEntity.ok("Category added successfully!");
	}

	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts() {
		return ResponseEntity.ok(productService.getAllProducts());
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateProducts(@PathVariable Long id, @RequestBody ProductDto productDto) {
		productService.updateProduct(id, productDto);
		return ResponseEntity.ok("Category updated successfully!");
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
		return ResponseEntity.ok("Category deleted successfully!");
	}
}
