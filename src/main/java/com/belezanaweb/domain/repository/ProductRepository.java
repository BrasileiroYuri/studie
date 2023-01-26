package com.belezanaweb.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.belezanaweb.domain.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
