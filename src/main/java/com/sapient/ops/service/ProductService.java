package com.sapient.ops.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sapient.ops.dao.ProductRepository;
import com.sapient.ops.exception.ResourceNotFoundException;
import com.sapient.ops.model.Product;

@Service
public class ProductService implements IProductService{
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Integer product_id, Product productDetails) {
		Product product = productRepository.findById(Integer.toUnsignedLong(product_id)).orElseThrow( () -> new ResourceNotFoundException("Product","id",product_id));
		product.setProduct_name(productDetails.getProduct_name());
		product.setDescription(productDetails.getDescription());
		product.setManufacture_date(productDetails.getManufacture_date());
		product.setBuying_price(productDetails.getBuying_price());
		Product updatedProduct = productRepository.save(product);
		return updatedProduct;
	}

	@Override
	public ResponseEntity<?> deleteProduct(Integer product_id) {
		Product product = productRepository.findById(Integer.toUnsignedLong(product_id)).orElseThrow( () -> new ResourceNotFoundException("Product","id",product_id));
		productRepository.delete(product);
		return ResponseEntity.ok().build();
	}

}
