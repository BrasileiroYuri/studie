package com.belezanaweb.domain.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long quantity;
	
	@OneToOne
	private Product product;

	@OneToOne
	private Warehouse warehouse;

}
