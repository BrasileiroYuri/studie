package com.belezanaweb.domain.exception;

public class SkuNotAllowedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SkuNotAllowedException(String message) {
		super(message);
	}

	public SkuNotAllowedException(Long productSku) {
		this(String.format("The product with id '%d' already exists!.", productSku));
	}

}
