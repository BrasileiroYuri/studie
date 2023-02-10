package com.belezanaweb.api.model.assembler;

import java.util.List;

import org.springframework.stereotype.Component;

import com.belezanaweb.api.model.output.InventoryModel;
import com.belezanaweb.api.model.output.ProductModelOutput;
import com.belezanaweb.api.model.output.WarehouseModel;
import com.belezanaweb.domain.model.Product;

@Component
public final class ProductModelAssembler {

    public ProductModelOutput toModel(Product product) {
        List<WarehouseModel> warehouseModels = getWarehouseModels(product);
        var inventoryModel = InventoryModel.builder().quantity(product.getQuantity()).
                warehouses(warehouseModels).build();
        return ProductModelOutput.builder().sku(product.getSku()).name(product.getName())
                .isMarkeatable(product.isMarkeatable()).inventory(inventoryModel).build();
    }

    private List<WarehouseModel> getWarehouseModels(Product product) {
        return product.getInventory().stream().map(inventory -> {
            var warehouseModel = new WarehouseModel();
            warehouseModel.setQuantity(inventory.getQuantity());
            warehouseModel.setType(inventory.getWarehouse().getType().toString());
            warehouseModel.setLocality(inventory.getWarehouse().getLocality());
            return warehouseModel;
        }).toList();
    }

    public List<ProductModelOutput> toCollectionModel(List<Product> products) {
        return products.stream().map(product -> toModel(product)).toList();
    }

}
