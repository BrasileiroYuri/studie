package com.belezanaweb.api.model.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductModelOutput {

    @NotNull
    private Long sku;

    @NotBlank
    private String name;

    @Valid
    @NotNull
    private InventoryModel inventory;

    @JsonProperty(access = Access.READ_ONLY)
    private Boolean isMarkeatable;

}
