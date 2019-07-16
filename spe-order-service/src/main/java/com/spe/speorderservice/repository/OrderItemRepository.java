package com.spe.speorderservice.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spe.speorderservice.model.OrderItem;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

	Page<OrderItem> findByOrderId(Long orderId, Pageable pageable);

	Optional<OrderItem> findByIdAndOrderId(Long id, Long orderId);

}
