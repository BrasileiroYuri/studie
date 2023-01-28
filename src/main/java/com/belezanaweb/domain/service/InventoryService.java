package com.belezanaweb.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.belezanaweb.domain.model.Inventory;
import com.belezanaweb.domain.repository.InventoryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public final class InventoryService {

	private final InventoryRepository inventoryRepository;

	public void save(List<Inventory> inventories) {
		for (Inventory inventory : inventories) {
			if (!inventoryRepository.findAll().contains(inventory)) {
				inventoryRepository.save(inventory);
			}
		}
	}

}
