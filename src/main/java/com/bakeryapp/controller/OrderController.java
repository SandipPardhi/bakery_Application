package com.bakeryapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bakeryapp.dto.request.OrderDto;
import com.bakeryapp.dto.response.BillDto;
import com.bakeryapp.service.OrderService;

@RestController
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/placeorder")
	public BillDto placeOrder(@RequestBody OrderDto orderDto) {
		return orderService.placeOrder(orderDto);
	}
	
}
