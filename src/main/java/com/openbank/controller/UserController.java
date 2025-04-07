package com.openbank.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;




/**
* This controller class includes 
* the implementation to show user details 
* 
* @author  inamsoomro
* @version 1.0
* @since   2019-05-25 
* 
*/

@Controller
public class UserController {


	private final static Logger LOGGER = Logger.getLogger(UserController.class.getName());
	
	
	
	/**
	 * This method shows the details of logged in user
	 * @param model - set the variables and views to be binded to views
	 * @return name of the view
	 */
	@RequestMapping(value ="/user")
	public String showLoggedInUser (Model model) {
		LOGGER.log(Level.INFO, "executing method showLoggedInUser ");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("user", "Welcome User "+auth.getName());
		
		LOGGER.log(Level.INFO, "loading the view for user "+auth.getName());
		return "user";
	}
}
