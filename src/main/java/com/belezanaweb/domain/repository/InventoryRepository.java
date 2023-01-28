package com.belezanaweb.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.belezanaweb.domain.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

}
