package com.belezanaweb.api.model.input;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ProductModelInput {

//	@JsonIgnore
	private Long sku;

	@NotBlank
	private String name;

	private List<WarehouseModelInput> warehouses;

}
