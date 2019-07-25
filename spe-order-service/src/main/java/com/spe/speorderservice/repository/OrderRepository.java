package com.spe.speorderservice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.spe.speorderservice.model.Order;

public interface OrderRepository extends MongoRepository<Order, Long> {

	Page<Order> findById(Long id, Pageable pageable);

//	Optional<Order> findByIdAndOrderId(Long id, Long orderId);

}
