package com.belezanaweb.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Warehouse {

	@Id
	private Long id;

	private String locality;

	private String name;

	@Enumerated(EnumType.STRING)
	private Type type;

}
