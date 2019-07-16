package com.spe.speproductservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spe.speproductservice.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
