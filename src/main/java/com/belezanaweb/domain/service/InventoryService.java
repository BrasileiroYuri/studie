package com.belezanaweb.domain.service;

import com.belezanaweb.domain.model.Inventory;
import com.belezanaweb.domain.repository.InventoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public final class InventoryService {

    private final InventoryRepository inventoryRepository;

    public void save(List<Inventory> inventories) {
        inventories.stream().forEach(inventory -> {
            if (!inventoryRepository.existsByWarehouseIdAndProductSku
                    (inventory.getWarehouse().getId(), inventory.getProduct().getSku())) {
                inventoryRepository.save(inventory);
            } else {
                var id = inventoryRepository.findByWarehouseIdAndProductSku
                        (inventory.getWarehouse().getId(), inventory.getProduct().getSku()).getId();
                inventory.setId(id);
                inventoryRepository.save(inventory);
            }
        });
    }

}


