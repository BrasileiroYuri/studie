package com.belezanaweb.api.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.belezanaweb.domain.repository.ProductRepository;
import com.belezanaweb.domain.service.ProductService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/produtos")
@AllArgsConstructor
public class ProdutoController {

	private final ProductRepository productRepository;
	private final ProductService productService;

	@GetMapping("/{sku}")
	public void buscarPorSku(@PathVariable Long sku) {
		productRepository.findById(sku);
	}

	@PostMapping("/{sku}")
	public void adicionarPorSku(@PathVariable Long sku) {
		productRepository.findById(sku);
	}

	@PutMapping("/{sku}")
	public void atualizarPorSku(@PathVariable Long sku) {
		productRepository.findById(sku);
	}

	@DeleteMapping("/{sku}")
	public void excluirPorSku(@PathVariable Long sku) {
		productRepository.findById(sku);
	}

}
