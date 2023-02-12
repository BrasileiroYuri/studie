package com.belezanaweb.api.controller;

import com.belezanaweb.domain.model.Warehouse;
import com.belezanaweb.domain.service.WarehouseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/warehouses")
@AllArgsConstructor
public class WarehouseController {

    private WarehouseService warehouseService;

    @GetMapping("/{id}")
    public Warehouse findById(@PathVariable Long id) {
        return warehouseService.findOrFail(id);
    }

    @PostMapping
    public Warehouse post(@RequestBody Warehouse warehouse) {
        return warehouseService.save(warehouse);
    }

}
