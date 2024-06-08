package com.kani.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kani.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {

	void deleteByProductName(String productName);

	Product findByProductName(String productName);

}
