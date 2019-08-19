package com.sapient.ops.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/modulec")
public class ModuleController {
	  	
	@RequestMapping(method=RequestMethod.GET)
	public String viewMainMenu(@RequestParam(value = "ops")String ops, Model model) {
		if(ops.equals("customer")) {
			return "customer_menu";
		}else if(ops.equals("product")) {
			return "product_menu";
		}
		else {
			model.addAttribute("message","PAGE_UNDER_CONSTRUCTION");
			return "status";
		}
	}
}
