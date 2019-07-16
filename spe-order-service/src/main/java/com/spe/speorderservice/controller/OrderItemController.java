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
import com.spe.speorderservice.model.OrderItem;
import com.spe.speorderservice.repository.OrderItemRepository;
import com.spe.speorderservice.repository.OrderRepository;

@RestController
@RequestMapping("/spe-order")
public class OrderItemController {

	@Autowired
	OrderItemRepository orderItemRepository;

	@Autowired
	OrderRepository orderRepository;

	@GetMapping(path = "/orders/{orderId}/order-items")
	public Page<OrderItem> getOrderItemsByOrderId(@PathVariable(name = "orderId") Long orderId, 
			Pageable pageable) {

		return orderItemRepository.findByOrderId(orderId, pageable);
	}

	@PostMapping(path = "/orders/{orderId}/order-items")
	public OrderItem createOrderItem(@PathVariable(name = "orderId") Long orderId, 
			@Valid @RequestBody OrderItem orderItemRequest) {

		return orderRepository.findById(orderId).map(order -> {
			orderItemRequest.setOrder(order);
			return orderItemRepository.save(orderItemRequest);
		}).orElseThrow(() -> new ResourceNotFoundException("Order", "Id", orderId));
	}

	@PutMapping(path = "/orders/{orderId}/order-items/{itemId}")
	public OrderItem updateOrderItem(@PathVariable(name = "orderId") Long orderId, 
			@PathVariable(name = "itemId") Long itemId, 
			@Valid @RequestBody OrderItem orderItemRequest) {

		if(!orderRepository.existsById(orderId)) {
			throw new ResourceNotFoundException("Order", "Id", orderId);
		}

		return orderItemRepository.findById(itemId).map(orderItem -> {
			orderItem.setProductId(orderItemRequest.getProductId());
			return orderItemRepository.save(orderItem);
		}).orElseThrow(()-> new ResourceNotFoundException("OrderItem", "Id", itemId));
	}

	@DeleteMapping(path = "/orders/{orderId}/order-items/{itemId}")
	public ResponseEntity<?> deleteOrderItem(@PathVariable(name = "orderId") Long orderId, 
			@PathVariable(name = "itemId") Long itemId) {
		return orderItemRepository.findByIdAndOrderId(itemId, orderId).map(orderItem -> {
			orderItemRepository.delete(orderItem);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("OrderItem", "Id", itemId));
	}

}
