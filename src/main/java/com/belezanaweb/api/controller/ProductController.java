package com.belezanaweb.api.controller;

import com.belezanaweb.api.model.disassembler.ProductModelDisassembler;
import com.belezanaweb.domain.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.belezanaweb.api.model.assembler.ProductModelAssembler;
import com.belezanaweb.api.model.input.ProductModelInput;
import com.belezanaweb.api.model.output.ProductModelOutput;
import com.belezanaweb.domain.model.Product;
import com.belezanaweb.domain.service.ProductService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ProductModelAssembler modelAssembler;
    private final ProductModelDisassembler modelDisassembler;
    private ProductRepository productRepositoy;

    @GetMapping("/{sku}")
    public ProductModelOutput findBySku(@PathVariable Long sku) {
        return modelAssembler.toModel(productService.findBySku(sku));
    }

    @GetMapping
    public List<ProductModelOutput> findAllBySku() {
        return modelAssembler.toCollectionModel(productRepositoy.findAll());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductModelOutput postBySku(@RequestBody @Valid ProductModelInput productModelInput) {
        productService.verifySku(productModelInput.getSku());
        Product product = modelDisassembler.toDomainModel(productModelInput);
        return modelAssembler.toModel(productService.save(product));
    }

    @PutMapping("/{sku}")
    public ProductModelOutput updateBySku(@PathVariable Long sku, @RequestBody @Valid ProductModelInput productModelInput) {
        productService.findBySku(sku);
        Product product = modelDisassembler.toDomainModel(productModelInput);
        product.setSku(sku);
        return modelAssembler.toModel(productService.save(product));
    }

    @DeleteMapping("/{sku}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBySku(@PathVariable Long sku) {
        productService.delete(sku);
    }

}
