package com.feedback.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.feedback.dto.UserCreateForm;
import com.feedback.service.UserService;
import com.feedback.validator.UserCreateFormValidator;

@Controller
public class RegisterController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserCreateFormValidator userFormValidator;

	@PostMapping("/registration")
	public String createUser(@Valid @ModelAttribute UserCreateForm userForm, BindingResult bindingResult) {

		userFormValidator.validate(userForm, bindingResult);
		if (bindingResult.hasErrors()) {
			return "register";
		}
		userService.createUser(userForm);
		return "login";
	}
}