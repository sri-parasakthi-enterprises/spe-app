package com.spe.speproductservice.controller;

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
import com.spe.speproductservice.model.Product;
import com.spe.speproductservice.repository.ProductRepository;

@RestController
@RequestMapping("/spe-product")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping(path = "/products")
	public Page<Product> geProducts(Pageable pageable) {
		return productRepository.findAll(pageable);
	}

	@PostMapping(path = "/products")
	public Product createProduct(@Valid @RequestBody Product product) {
		return productRepository.save(product);
	}

	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable(value = "id") Long productId) {
		return productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "Id", productId));
	}

	@PutMapping("/products/{id}")
	public Product updateProduct(@PathVariable(value = "id") Long productId, @Valid @RequestBody Product productRequest) {
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "Id", productId));
		
		product.setProductName(productRequest.getProductName());
		product.setProductDesc(productRequest.getProductDesc());
		product.setHsnCode(productRequest.getHsnCode());
		product.setSgstRate(productRequest.getSgstRate());
		product.setCgstRate(productRequest.getCgstRate());
		product.setIgstRate(productRequest.getIgstRate());

		return productRepository.save(product);
	}

	/*
	 * Delete party
	 */
	@DeleteMapping("/products/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable(value = "id") Long productId) {
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "Id", productId));

		productRepository.delete(product);

		return ResponseEntity.ok().build();
	}

}
