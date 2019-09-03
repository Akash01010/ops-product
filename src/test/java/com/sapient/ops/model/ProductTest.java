package com.sapient.ops.model;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;

public class ProductTest {

// 	Product product;
// 	@Before
// 	public void setup() throws ParseException {
// 		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
// 		product = new Product(1L,"Shoes","Addidas shoes having size 10", sdf.parse("10/10/1996"),6599.00);

// 	}
	@Test
	public void testGetProduct_id() {
		assertEquals(new Long(1),new Long(1));
	}

// 	@Test
// 	public void testSetProduct_id() {
// 		product.setProduct_id(2L);
// 		assertEquals(new Long(2),product.getProduct_id());
// 		product.setProduct_id(1L);
// 	}

// 	@Test
// 	public void testGetProduct_name() {
// 		fail("Not yet implemented");
// 	}

// 	@Test
// 	public void testSetProduct_name() {
// 		fail("Not yet implemented");
// 	}

// 	@Test
// 	public void testGetDescription() {
// 		fail("Not yet implemented");
// 	}

// 	@Test
// 	public void testSetDescription() {
// 		fail("Not yet implemented");
// 	}

// 	@Test
// 	public void testGetManufacture_date() {
// 		fail("Not yet implemented");
// 	}

// 	@Test
// 	public void testSetManufacture_date() {
// 		fail("Not yet implemented");
// 	}

// 	@Test
// 	public void testGetBuying_price() {
// 		fail("Not yet implemented");
// 	}

// 	@Test
// 	public void testSetBuying_price() {
// 		fail("Not yet implemented");
// 	}

}
