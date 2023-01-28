package com.belezanaweb.api.model;

import com.belezanaweb.api.model.output.InventoryModel;

public abstract class ProductModel {

	public abstract InventoryModel getInventory();

	public abstract Long getSku();

	public abstract String getName();

}
