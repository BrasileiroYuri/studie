package com.belezanaweb.domain.service;

import com.belezanaweb.domain.exception.WarehouseAlreadyExistsException;
import com.belezanaweb.domain.model.Warehouse;
import com.belezanaweb.domain.repository.WarehouseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WarehouseService {

    private final WarehouseRepository warehouseRepository;

    public Warehouse save(Warehouse warehouse) {
        findOrFail(warehouse.getId());
        return warehouseRepository.save(warehouse);
    }

    public Warehouse findOrFail(Long id) {
        return warehouseRepository.findById(id).orElseThrow(
                () -> new WarehouseAlreadyExistsException(id));
    }

}
