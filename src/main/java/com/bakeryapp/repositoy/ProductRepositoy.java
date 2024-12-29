package com.bakeryapp.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bakeryapp.entity.Product;

@Repository
public interface ProductRepositoy extends JpaRepository<Product, Long>{

}
