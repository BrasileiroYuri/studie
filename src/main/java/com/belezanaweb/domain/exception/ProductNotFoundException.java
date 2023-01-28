package com.belezanaweb.domain.exception;

public class ProductNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ProductNotFoundException(Long sku) {
		super(String.format("Product with id %d do not exists.", sku));
	}
}
