package com.belezanaweb.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.belezanaweb.domain.model.Warehouse;
import com.belezanaweb.domain.repository.WarehouseRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class WarehouseService {

    private final WarehouseRepository warehouseRepository;

}
