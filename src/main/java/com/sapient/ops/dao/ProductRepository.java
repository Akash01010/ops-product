package com.sapient.ops.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sapient.ops.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
