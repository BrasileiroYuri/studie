package com.belezanaweb.domain.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Product {

	@Id
	private Long sku;

	private String name;

	private Long quantity;

	@OneToMany(mappedBy = "product")
	@Column(nullable = false)
	private List<Inventory> inventory;

	public boolean isMarkeatable() {
		return getQuantity() > 0;
	}

}
