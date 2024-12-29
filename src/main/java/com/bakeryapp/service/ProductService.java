package com.bakeryapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bakeryapp.dto.ProductDto;
import com.bakeryapp.entity.Product;
import com.bakeryapp.repositoy.ProductCategoryRepository;
import com.bakeryapp.repositoy.ProductRepositoy;

@Service
public class ProductService {

	@Autowired
	private ProductRepositoy productRepositoy;
	
	@Autowired
	private ProductCategoryRepository categoryRepository;
	
	public void addProduct(ProductDto productDto) {
		Product product = new Product();
		
		product.setProductName(productDto.getProductName());
		product.setDescription(productDto.getDescription());
		product.setPrice(productDto.getPrice());
		product.setProductCategory(categoryRepository.findById(productDto.getCategoryId()).get());
		
		productRepositoy.save(product);
	}
	
	public List<Product> getAllProducts() {
        return productRepositoy.findAll();
    }

    public void updateProduct(Long id, ProductDto productDto) {
        Product product = productRepositoy.findById(id).get();
        product.setProductName(productDto.getProductName());
    	product.setDescription(productDto.getDescription());
    	product.setPrice(productDto.getPrice());
    	product.setProductCategory(categoryRepository.findById(productDto.getCategoryId()).get());
        productRepositoy.save(product);
    }

    public void deleteProduct(Long id) {
        productRepositoy.deleteById(id);
    }

}
