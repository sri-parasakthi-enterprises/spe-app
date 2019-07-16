package com.spe.speorderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spe.speorderservice.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
