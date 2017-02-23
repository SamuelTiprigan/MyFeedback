package com.feedback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.feedback.service.UserService;

/*
 * 	@PreAuthorize("hasAuthority('1')")  -- not working
 * 
 * */

@Controller
@RequestMapping(value = "/admin/users/")
public class AdminController {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getUsers() {
		ModelAndView model = new ModelAndView("admin/admin");
		if (userService.getAllUsers().size() > 0) {
			return model.addObject("users", userService.getAllUsers()).addObject("command", "users");
		}
		return model;
	}

	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView getUser(@PathVariable Long id) {
		ModelAndView model = new ModelAndView("admin/admin");
		if (userService.getUserById(id) !=null)
		{
			return model.addObject("user",userService.getUserById(id)).addObject("command", "userbyId");
		}
		return model.addObject("command", "userbyId");
	}

	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ModelAndView deleteUser(@PathVariable Long id) {
		ModelAndView model = new ModelAndView("admin/admin");
		
		return model.addObject("command", "users");
	}
}
