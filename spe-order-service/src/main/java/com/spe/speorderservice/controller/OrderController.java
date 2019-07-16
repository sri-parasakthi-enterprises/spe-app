package com.spe.speorderservice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spe.rest.service.exception.ResourceNotFoundException;
import com.spe.speorderservice.model.Order;
import com.spe.speorderservice.repository.OrderRepository;

@RestController
@RequestMapping("/spe-order")
public class OrderController {

	@Autowired
	OrderRepository orderRepository;

	@GetMapping(path = "/orders")
	public Page<Order> getAllOrders(Pageable pageable) {
		return orderRepository.findAll(pageable);
	}

	@PostMapping(path = "/orders")
	public Order createOrder(@Valid @RequestBody Order orderRequest) {
		return orderRepository.save(orderRequest);
	}

	@PutMapping(path = "/orders/{orderId}")
	public Order updateOrder(@PathVariable Long orderId, @Valid @RequestBody Order orderRequest) {
		return orderRepository.findById(orderId).map(order -> {
			order.setDescription(orderRequest.getDescription());
			order.setInvoiceId(orderRequest.getInvoiceId());
			order.setOrderStatus(orderRequest.getOrderStatus());
			return orderRepository.save(order);
		}).orElseThrow(() -> new ResourceNotFoundException("Order", "Id", orderId));
	}

	@DeleteMapping(path = "/orders/{orderId}")
	public ResponseEntity<?> deleteOrder(@PathVariable Long orderId) {
		return orderRepository.findById(orderId).map(order -> {
			orderRepository.delete(order);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("Order", "Id", orderId));
	}

}
