package com.belezanaweb.api.model;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InventoryModel {
	
	@PositiveOrZero
	private Long quantity;
	
	@Valid
	@NotNull
	private List<WarehouseModel> warehouses;
	

}
