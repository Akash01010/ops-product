package com.sapient.ops.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sapient.ops.exception.CustomerException;
import com.sapient.ops.exception.ProductException;
import com.sapient.ops.model.Customer;
import com.sapient.ops.model.Product;
import com.sapient.ops.service.IProductService;
import com.sapient.ops.utility.AppConfig;

@Controller
@RequestMapping("prodc")
public class ProductController {

	@Autowired
	IProductService productService;

	@RequestMapping(value="prereg" ,method=RequestMethod.GET)
	public ModelAndView productForm() {
		Product product =new Product();
		return new ModelAndView("prod_reg","product",product);
	}
	
	@RequestMapping(value="preUpdate" ,method=RequestMethod.GET)
	public String updateForm() {
		System.out.println("I'm in preUpdate");
		return "prod_update_form";
	}
	
	@RequestMapping(value="preDelete" ,method=RequestMethod.GET)
	public String deleteForm() {
		return "prod_delete_form";
	}
	@RequestMapping(value="/register" ,method=RequestMethod.POST)
	public ModelAndView addProduct( @ModelAttribute(value="product")Product product) {
		productService.createProduct(product);
		return new ModelAndView("prod_status","message","Product Added");
	}

	@RequestMapping(value="/allproducts", method=RequestMethod.GET)
	public ModelAndView getAllProductDetails() {
		List<Product> productList=productService.getAllProducts();
		if(productList.size()!=0) {				
			return new ModelAndView("all_products","productList",productList);
		}else {
			return new ModelAndView("prod_status","message","No products retrieved");
		}

	}


	@RequestMapping(value="/preeditp", method=RequestMethod.GET)
	public ModelAndView preUpdateProduct(@RequestParam(value="productid") String productid) {
		try {
			Long id=Long.valueOf(productid);
			Product product=productService.getProductById(id);
			return new ModelAndView("update_product","product",product);
		}catch(Exception e) {
			return new ModelAndView("status","message",e.getMessage());
		}
	}
	
	@RequestMapping(value="/posteditp", method=RequestMethod.POST)
	public ModelAndView postUpdateCustomer(@ModelAttribute(value="product") Product product) {
			productService.updateProduct(product.getProduct_id(), product);
			return new ModelAndView("prod_status","message","Product Successfully Updated");
	}
	
	@RequestMapping(value="/deletep", method=RequestMethod.GET)
	public ModelAndView deleteProduct(@RequestParam(value="productid") String productid) {
		productService.deleteProduct(Long.valueOf(productid));
		return new ModelAndView("prod_status","message","Deleted Product");

	}
	
	@RequestMapping(value="/pmenu")
	public String getCustomerMenu() {
		return "product_menu";
	}
	@RequestMapping("/mmenu")
	public String goToMainMenu() {
		return "main_menu";
	}
}
