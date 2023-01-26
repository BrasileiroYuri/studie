package com.belezanaweb.domain.service;

import org.springframework.stereotype.Service;

import com.belezanaweb.domain.model.Product;
import com.belezanaweb.domain.repository.ProductRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public final class ProductService {

	private final ProductRepository productRepository;

	public Product save(Product product) {
		calculateQuantity(product);
		productRepository.save(product);
		return product;
	}

	private void calculateQuantity(Product product) {
		product.setQuantity(product.getInventory().stream().mapToLong(inventory -> inventory.getQuantity()).sum());
	}

}
