package com.sapient.ops.rest;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import com.sapient.ops.exception.CustomerException;
import com.sapient.ops.model.Customer;
import com.sapient.ops.service.CustomerService;
import com.sapient.ops.utility.AppConfig;

@RestController
@RequestMapping("/crest")
public class CustomerRESTController {
	@Autowired
	private CustomerService customerService;
	private Logger restLogger= 
			Logger.getLogger(CustomerRESTController.class);		
	
	
	@PostMapping(value="/register")
	public ResponseEntity<String> addCustomer( @Valid @RequestBody Customer customer) {
		
		try {
			String status=customerService.addCustomer(customer);
			restLogger.info(AppConfig.PROPERTIES.getProperty("CUSTOMER_INSERT.SUCCESS"));
			return new ResponseEntity<>(status,HttpStatus.OK);
		} catch (CustomerException e) {	
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}		
	}
	
	//http://localhost:8080/ops-spring-jpa-web-app/crest/getc/1	
	@GetMapping(value = "/getc/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "id") String id) {
		try {
			Integer ID= Integer.parseInt(id);
			Customer customer=customerService.getCustomerById(ID);
			restLogger.info(AppConfig.PROPERTIES.getProperty("CUSTOMER_READ.SUCCESS"));
			return new ResponseEntity<>(customer,HttpStatus.OK);
		} catch (CustomerException e) {	
			restLogger.error(AppConfig.PROPERTIES.getProperty("CUSTOMER_READ.FAIL"));			
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}	
	}
	
	//http://localhost:8080/ops-spring-jpa-web-app/crest/allc
	@GetMapping(value="/allc")
	public List<Customer> getAllCustomers() {
		try {
			List<Customer> customerList=customerService.getAllCustomerDetails();
			if(customerList.size()!=0) {				
				return customerList;
			}else {
				return null;
			}
		}catch(CustomerException e) {
			e.printStackTrace();
			restLogger.error(AppConfig.PROPERTIES.getProperty("CUSTOMER_READALL.FAIL"), e);
			return null;
		}
	}
	
	
	
	@PutMapping(value="/updatec")
	public ResponseEntity<String> updateCustomer(@RequestBody Customer customer) {
		try {			
			int n=customerService.updateCustomer(customer);
			return new ResponseEntity<>(new Integer(n).toString(),
												HttpStatus.OK);
		}catch(CustomerException e) {
			restLogger.error(AppConfig.PROPERTIES.getProperty("CUSTOMER_UPDATE.FAIL"), e);
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(value="/deletec/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable(value="id") Integer id) {
		try {			
			Integer n= customerService.deleteCustomer(id);
			return new ResponseEntity<>(n.toString(),HttpStatus.OK);
		}catch(CustomerException e) {
			restLogger.error(AppConfig.PROPERTIES.getProperty("CUSTOMER_DELETE.FAIL"), e);
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}	
	
	
}
