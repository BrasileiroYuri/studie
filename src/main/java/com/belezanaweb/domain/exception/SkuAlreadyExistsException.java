package com.belezanaweb.domain.exception;

public class SkuAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SkuAlreadyExistsException(String message) {
		super(message);
	}

	public SkuAlreadyExistsException(Long productSku) {
		this(String.format("The product with id '%d' already exists!.", productSku));
	}

}
