package com.sapient.ops.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sapient.ops.entity.User;
import com.sapient.ops.service.UserService;

@Controller
@RequestMapping(value="/logc")
public class LoginController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView viewLogin() {
		return new ModelAndView("login","user",new User());
	}
	
	
	@RequestMapping(value="/verify", method=RequestMethod.POST)
	public String doLogin( @Valid @ModelAttribute("user") User user,
			BindingResult result, HttpServletRequest request, Model model){
		try {
			if(result.hasErrors()) {
				List<ObjectError> errorList=result.getAllErrors();
				System.out.println(errorList);
				return "login";
			}else {
				User validUser= userService.getUserDetails(user.getUserName(),user.getPassword());
				//if(validUser !=null) {
					HttpSession session= request.getSession();
					session.setAttribute("validUser", validUser);					
					return "main_menu";
				//}
//				else{
//					model.addAttribute("message","Invalid Credentials");
//					return "status";
//				}
			}
		} catch (Exception e) {			
			e.printStackTrace();
			model.addAttribute("message","Invalid Credentials");
			return "status";
		}		
//		model.addAttribute("status","Invalid Credentials");
//		return "statuslog";
	}

	
	
	@RequestMapping(value = "/logout",method=RequestMethod.GET)
	public String viewLogout(Model model, HttpServletRequest request) {
		HttpSession session= request.getSession(false);
		if(session!=null) {
			session.removeAttribute("validUser");
			session.invalidate();
			model.addAttribute("message","Logged out..");
			return "status";
		}else {
			model.addAttribute("message","Already Logged out..");
			return "login";
		}
		
	}
	
}