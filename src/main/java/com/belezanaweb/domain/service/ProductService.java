package com.belezanaweb.domain.service;

import org.springframework.stereotype.Service;

import com.belezanaweb.domain.exception.ProductNotFoundException;
import com.belezanaweb.domain.exception.SkuAlreadyExistsException;
import com.belezanaweb.domain.model.Product;
import com.belezanaweb.domain.repository.ProductRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public final class ProductService {

    private final ProductRepository productRepository;
    private final InventoryService inventoryService;

    public Product save(Product product) {
        product.calculateQuantity();
        productRepository.save(product);
        inventoryService.save(product.getInventory());
        return product;
    }

    public Product findBySku(Long sku) {
        return productRepository.findById(sku).orElseThrow(() -> new ProductNotFoundException(sku));
    }

    public void delete(Long sku) {
        productRepository.deleteById(sku);
    }

    public void verifySku(Long sku) {
        productRepository.findById(sku).ifPresent(product -> {
            throw new SkuAlreadyExistsException(sku);
        });
    }

}
