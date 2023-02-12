package com.belezanaweb.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

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
	public void calculateQuantity() {
		setQuantity(getInventory().stream().mapToLong(Inventory::getQuantity).sum());
	}
}
