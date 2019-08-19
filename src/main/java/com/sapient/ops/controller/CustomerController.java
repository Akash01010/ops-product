package com.sapient.ops.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sapient.ops.exception.CustomerException;
import com.sapient.ops.model.Customer;
import com.sapient.ops.service.CustomerService;
import com.sapient.ops.utility.AppConfig;

@Controller
@RequestMapping(value="/custc")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	private Logger clientLogger= Logger.getLogger(CustomerController.class);
		
	
	@RequestMapping(value="prereg" ,method=RequestMethod.GET)
	public ModelAndView customerForm() {
		Customer customer=new Customer();
		return new ModelAndView("cust_reg","customer",customer);
	}

	@RequestMapping(value="/register" ,method=RequestMethod.POST)
	public ModelAndView addCustomer( @ModelAttribute(value="customer")Customer customer) {
		//System.out.println(customer.getCustomerName());
		try {
			String status=customerService.addCustomer(customer);
			clientLogger.info(AppConfig.PROPERTIES.getProperty("CUSTOMER_INSERT.SUCCESS"));
			return new ModelAndView("cust_status","message",status);
		} catch (CustomerException e) {	
			clientLogger.error(AppConfig.PROPERTIES.getProperty("CUSTOMER_INSERT.FAIL"), e);
			return new ModelAndView("status","message",e.getMessage());
		}		
	}
	
	@RequestMapping(value="preget" ,method=RequestMethod.GET)
	public String getCustomerIdForm() {		
		return"get_customer_id";
	}
	
	@RequestMapping(value = "/getc", method =RequestMethod.GET)
	public ModelAndView getCustomerById(@RequestParam(value = "customerid", required = true,defaultValue ="1" ) String id) {
		try {
			Integer ID= Integer.parseInt(id);
			Customer customer=customerService.getCustomerById(ID);
			clientLogger.info(AppConfig.PROPERTIES.getProperty("CUSTOMER_READ.SUCCESS"));
			return new ModelAndView("customer_details","customer",customer);
		} catch (CustomerException e) {	
			clientLogger.error(AppConfig.PROPERTIES.getProperty("CUSTOMER_READ.FAIL"), e);
			return new ModelAndView("status","message",e.getMessage());
		}	
	}
	
	@RequestMapping(value="/allc", method=RequestMethod.GET)
	public ModelAndView getAllCustomerDetails() {
		try {
			List<Customer> customerList=customerService.getAllCustomerDetails();
			if(customerList.size()!=0) {				
				return new ModelAndView("all_customers","customerList",customerList);
			}else {
				return new ModelAndView("cust_status","message",AppConfig.PROPERTIES.getProperty("CUSTOMER_READ.EMPTY"));
			}
		}catch(CustomerException e) {
			e.printStackTrace();
			clientLogger.error(AppConfig.PROPERTIES.getProperty("CUSTOMER_READALL.FAIL"), e);
			return new ModelAndView("status","message",e.getMessage());
		}
	}
	
	@RequestMapping(value="/preeditc", method=RequestMethod.GET)
	public ModelAndView preUpdateCustomer(@RequestParam(value="customerid") String customerid) {
		try {
			int id=Integer.parseInt(customerid);
			Customer customer=customerService.getCustomerById(id);
			return new ModelAndView("update_customer","customer",customer);
		}catch(CustomerException e) {
			return new ModelAndView("status","message",e.getMessage());
		}catch(Exception e) {
			return new ModelAndView("status","message",e.getMessage());
		}
	}
	
	@RequestMapping(value="/posteditc", method=RequestMethod.POST)
	public ModelAndView postUpdateCustomer(@ModelAttribute(value="customer") Customer customer) {
		try {
			//System.out.println(customer.getCustomerName());
			int n=customerService.updateCustomer(customer);
			if(n>0) {
				return new ModelAndView("cust_status","message",AppConfig.PROPERTIES.getProperty("CUSTOMER_UPDATE.SUCCESS"));
			}else {
				return new ModelAndView("cust_status","message",AppConfig.PROPERTIES.getProperty("CUSTOMER_UPDATE.FAIL"));
			}
		}catch(CustomerException e) {
			clientLogger.error(AppConfig.PROPERTIES.getProperty("CUSTOMER_UPDATE.FAIL"), e);
			return new ModelAndView("status","message",e.getMessage());
		}
	}
	
	@RequestMapping(value="/deletec", method=RequestMethod.GET)
	public ModelAndView deleteCustomer(@RequestParam(value="customerid") String customerid) {
		try {
			int id=Integer.parseInt(customerid);
			int n= customerService.deleteCustomer(id);
			if(n>0) {
				return new ModelAndView("cust_status","message",AppConfig.PROPERTIES.getProperty("CUSTOMER_DELETE.SUCCESS"));
			}else {
				return new ModelAndView("cust_status","message",AppConfig.PROPERTIES.getProperty("CUSTOMER_DELETE.FAIL"));
			}
		}catch(CustomerException e) {
			clientLogger.error(AppConfig.PROPERTIES.getProperty("CUSTOMER_DELETE.FAIL"), e);
			return new ModelAndView("status","message",e.getMessage());
		}
	}
	
	
	@RequestMapping(value="/cmenu")
	public String getCustomerMenu() {
		return "customer_menu";
	}
	
	@RequestMapping("/mmenu")
	public String goToMainMenu() {
		return "main_menu";
	}
}