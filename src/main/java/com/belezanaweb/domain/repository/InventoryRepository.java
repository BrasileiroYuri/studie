package com.belezanaweb.domain.repository;

import com.belezanaweb.domain.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

import com.belezanaweb.domain.model.Inventory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

}

