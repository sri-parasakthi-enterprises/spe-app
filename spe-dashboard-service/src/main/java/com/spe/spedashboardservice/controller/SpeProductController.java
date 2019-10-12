package com.spe.spedashboardservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spe.spedashboardservice.model.Product;
import com.spe.spedashboardservice.proxy.SpeProductServiceProxy;

@RefreshScope
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/spe-dashboard")
public class SpeProductController {

	@Autowired
	SpeProductServiceProxy productServiceProxy;

	@GetMapping("/products")
	public Page<Product> getAllParties(Pageable pageable) {
//		List<Party> partyList = new ArrayList<Party>();

		Page<Product> productPage = productServiceProxy.getAllProducts(pageable);

		return productPage;
	}

	@GetMapping("/products/{id}")
	public Product findProductById(@PathVariable(value = "id") Long id) {
		return productServiceProxy.getProductById(id);
	}

}
