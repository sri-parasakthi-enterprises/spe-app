package com.spe.speproductservice.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.spe.speproductservice.model.Product;

public interface ProductRepository extends MongoRepository<Product, Long> {

	Page<Product> findById(Long id, Pageable pageable);

	@Query("{productName: { $regex: ?0 } })")
    List<Product> findPartyByRegExProductName(String productName);

}
