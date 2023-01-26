package com.belezanaweb.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Inventory {

	@Id
	private Long id;

	private Long quantity;
	
	@OneToOne
	private Product product;

	@OneToOne
	private Warehouse warehouse;

}
