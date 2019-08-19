package com.sapient.ops.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sapient.ops.model.Product;

public interface IProductService {
	public List<Product> getAllProducts();
	public Product createProduct(Product product);
	public Product updateProduct(Integer product_id, Product productDetails);
	public ResponseEntity<?> deleteProduct(Integer product_id);
}
