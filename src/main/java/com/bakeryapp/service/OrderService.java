package com.bakeryapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bakeryapp.dto.request.OrderDto;
import com.bakeryapp.dto.response.BillDto;
import com.bakeryapp.dto.response.ProductOrderDto;
import com.bakeryapp.entity.Bill;
import com.bakeryapp.entity.Order;
import com.bakeryapp.entity.Product;
import com.bakeryapp.repositoy.BillRepository;
import com.bakeryapp.repositoy.OrderRepository;
import com.bakeryapp.repositoy.ProductRepositoy;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private BillRepository billRepository;

	@Autowired
	private ProductRepositoy productRepositoy;

	public BillDto placeOrder(OrderDto orderDto) {
		Set<Long> orderProductIds = orderDto.getProductWithQuantities().keySet();

		List<Product> products = productRepositoy.findAllById(orderProductIds);

		Double totalAmount = 0D;
		for (Map.Entry<Long, Long> entry : orderDto.getProductWithQuantities().entrySet()) {
			Long productId = entry.getKey();
			Long productQuantity = entry.getValue();
			Product product = products.stream().filter(prd -> prd.getId() == productId).findFirst().get();
			totalAmount += productQuantity * product.getPrice();

		}
		Bill bill = new Bill();

		bill.setCustomerName(orderDto.getCustomerName());
		bill.setContactNo(orderDto.getContactNo());
		bill.setDiscountPercent(orderDto.getDiscountPrecent());
		bill.setTotalAmount(totalAmount);
		bill.setFinalAmount(totalAmount - (totalAmount / 100) * orderDto.getDiscountPrecent());

		Bill savedBill = billRepository.save(bill);

		List<Order> orderItems = new ArrayList<>();
		orderItems.addAll(products.stream().map(
				prd -> new Order(null, savedBill, prd.getId(), orderDto.getProductWithQuantities().get(prd.getId())))
				.toList());
		
		orderRepository.saveAll(orderItems);
		savedBill.setOrderItem(orderItems);
		billRepository.save(savedBill);
		return this.retriveBill(savedBill.getId(), products);
	}

	public BillDto retriveBill(Long billId, List<Product> products) {
		Bill bill = billRepository.findById(billId).get();
		BillDto billDto = new BillDto();
		billDto.setBillId(bill.getId());
		billDto.setCustomerName(bill.getCustomerName());
		billDto.setContactNo(bill.getContactNo());
		billDto.setDiscountPercent(bill.getDiscountPercent());
		billDto.setTotalAmount(bill.getTotalAmount());
		billDto.setFinalAmount(bill.getFinalAmount());
		List<ProductOrderDto> productOrderDtos = bill.getOrderItem().stream().map(ord -> {
			Product prod = products.stream().filter(prd -> prd.getId() == ord.getProductId()).findFirst().get();
			return new ProductOrderDto(prod.getProductName(), ord.getQuantity(), prod.getPrice());
		}).toList();
		billDto.setOrderedProducts(productOrderDtos);
		return billDto;
	}

}
