package com.spe.spedashboardservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spe.spedashboardservice.model.Product;

@FeignClient(name = "SpeProductService")
public interface SpeProductServiceProxy {

	@RequestMapping("/spe-product/products")
	public Page<Product> getAllProducts(Pageable pageable);

	@RequestMapping("/spe-product/products/{id}")
	public Product getProductById(@PathVariable(value = "id") Long productId);	

}
