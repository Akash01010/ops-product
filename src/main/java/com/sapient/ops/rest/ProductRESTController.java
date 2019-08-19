package com.sapient.ops.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.ops.model.Product;
import com.sapient.ops.service.IProductService;

@RestController
@RequestMapping("/prest")
public class ProductRESTController {

	@Autowired
	IProductService productService;

	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@PostMapping("/products")
	public Product createProduct(@Valid @RequestBody Product product) {
		return productService.createProduct(product);
	}

	@PutMapping("/product/{id}")
	public Product updateProduct(@PathVariable(value = "id") Long productId, @Valid @RequestBody Product productDetails) { 
		return productService.updateProduct(productId.intValue(), productDetails); 
	} 

	// Delete a Note 
	@DeleteMapping("/product/{id}") 
	public ResponseEntity<?> deleteProduct(@PathVariable(value = "id") Long productId) { 
		return productService.deleteProduct(productId.intValue()); 
	}

}
