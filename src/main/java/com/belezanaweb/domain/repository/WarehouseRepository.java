package com.belezanaweb.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.belezanaweb.domain.model.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

}
