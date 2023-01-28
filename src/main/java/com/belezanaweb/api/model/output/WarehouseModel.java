package com.belezanaweb.api.model.output;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WarehouseModel {

	@NotBlank
	private String locality;

	@NotNull
	private Long quantity;

	@NotBlank
	private String type;

}
