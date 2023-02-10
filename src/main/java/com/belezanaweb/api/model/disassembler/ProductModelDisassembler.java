package com.belezanaweb.api.model.disassembler;

import com.belezanaweb.api.model.input.ProductModelInput;
import com.belezanaweb.api.model.input.WarehouseModelInput;
import com.belezanaweb.domain.model.Inventory;
import com.belezanaweb.domain.model.Product;
import com.belezanaweb.domain.repository.WarehouseRepository;
import com.belezanaweb.domain.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ProductModelDisassembler {

    private ProductService productService;
    private WarehouseRepository warehouseRepository;

    public Product toDomainModel(ProductModelInput productModelInput) {
        var product = new Product();
        product.setSku(productModelInput.getSku());
        product.setName(productModelInput.getName());
        product.setQuantity(productModelInput.getWarehouses().stream()
                .mapToLong(WarehouseModelInput::getQuantity).sum());
        List<Inventory> inventories =
                productModelInput.getWarehouses().stream().map(warehouseModelInput -> {
                    var inventory = new Inventory();
                    inventory.setProduct(product);
                    inventory.setQuantity(warehouseModelInput.getQuantity());
                    inventory.setWarehouse(warehouseRepository.findById(warehouseModelInput.getId())
                            .orElseThrow(() -> new RuntimeException()));
                    return inventory;
                }).toList();
        product.setInventory(inventories);
        return product;
    }

}
