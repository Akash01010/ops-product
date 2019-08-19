package com.sapient.ops.service;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import com.sapient.ops.dao.ProductRepository;
import com.sapient.ops.model.Product;

public class ProductServiceTests {

	@Mock
	ProductRepository productRepository;
	
	@InjectMocks
	ProductService productService;
	
	Product product;
	Product updatedProduct;
	@Before
	public void setup() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		product = new Product(new Integer(1),"Shoes","Addidas shoes having size 10", sdf.parse("10/10/1996"),6599.00);
		updatedProduct = new Product(new Integer(1),"Shoes","Addidas shoes having size 11", sdf.parse("10/10/1996"),6499.00);
	}
	
	@Test
	public void testGetAllProducts() {
		Mockito.when(productRepository.findAll()).thenReturn((List<Product>) product);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Product> allProducts = productService.getAllProducts();
		assertEquals(new Integer(1),allProducts.get(0).getProduct_id());
		assertEquals("Shoes",allProducts.get(0).getProduct_name());
		assertEquals("Addidas shoes having size 10",allProducts.get(0).getDescription());
		try {
			assertEquals(sdf.parse("10/10/1996"),allProducts.get(0).getManufacture_date());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(new Double(6499.00),allProducts.get(0).getBuying_price());
	}
	
	@Test
	public void testCreateProduct() {
		Mockito.when(productRepository.save(product)).thenReturn(product);
		assertEquals(product.toString(),productService.createProduct(product).toString());
	}
	
	@Test
	public void testUpdateProduct() {
		Mockito.doReturn(product).when(productRepository).findById(Integer.toUnsignedLong(new Integer(1)));
		Mockito.when(productRepository.save(product)).thenReturn(product);
		assertEquals(updatedProduct, productService.updateProduct(new Integer(1), updatedProduct));
		
	}
	
	@Test
	public void testDeleteProduct() {
		Mockito.doReturn(product).when(productRepository).findById(Integer.toUnsignedLong(new Integer(1)));
		assertEquals(ResponseEntity.ok(),productService.deleteProduct(1));
	}
	
}
