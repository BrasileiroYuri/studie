package com.belezanaweb.domain.repository;

import com.belezanaweb.domain.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    boolean existsByWarehouseIdAndProductSku(Long warehouseId, Long productSku);
    Inventory findByWarehouseIdAndProductSku(Long warehouseId, Long productSku);



}



