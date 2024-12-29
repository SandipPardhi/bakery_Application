package com.bakeryapp.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bakeryapp.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
