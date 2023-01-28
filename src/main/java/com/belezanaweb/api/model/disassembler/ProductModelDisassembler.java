package com.belezanaweb.api.model.disassembler;

import java.util.List;

import org.springframework.stereotype.Component;

import com.belezanaweb.api.model.ProductModel;
import com.belezanaweb.domain.model.Inventory;
import com.belezanaweb.domain.model.Product;
import com.belezanaweb.domain.model.Type;
import com.belezanaweb.domain.model.Warehouse;

@Component
public final class ProductModelDisassembler {

	public Product toDomainModel(ProductModel productModel) {
		Product product = new Product();
		product.setSku(productModel.getSku());
		product.setName(productModel.getName());
		product.setQuantity(productModel.getInventory().getQuantity());
		List<Inventory> inventories = getInventories(productModel, product);
		product.setInventory(inventories);
		return product;
	}

	private List<Inventory> getInventories(ProductModel productModel, Product product) {
		return productModel.getInventory().getWarehouses().stream().map(warehouse -> {
			var inventory = new Inventory();
			inventory.setProduct(product);
			inventory.setQuantity(warehouse.getQuantity());
			var newWarehouse = new Warehouse();
			newWarehouse.setLocality(warehouse.getLocality());
			newWarehouse.setType(Type.valueOf(warehouse.getType()));
			inventory.setWarehouse(newWarehouse);
			return inventory;
		}).toList();
	}

}
