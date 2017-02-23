package com.feedback.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.feedback.dto.UserCreateForm;
import com.feedback.service.UserService;
import com.feedback.utils.Utils;

@Component
public class UserCreateFormValidator implements Validator {

	@Autowired
	private UserService userService;

	@Override
	public boolean supports(Class<?> clazz) {
		return userService.equals(UserCreateForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {

		UserCreateForm userForm = (UserCreateForm) target;

		if (!userForm.getPassword().equals(userForm.getPasswordRepeated())) {
			errors.rejectValue("password", "password.no_match", "Passwords don't match!");
		}
		if (userService.getUserByEmail(userForm.getEmail()) != null) {
			errors.reject("email.exists", "User with this email already exists");
		}

		if (userService.getUserByUsername(Utils.optainUsername(userForm.getEmail())) != null) {
			errors.reject("email.exists", "User with this username already exists");
		}

		if (userForm.getName().length() < 5 || !userForm.getName().contains(" ")) {
			errors.reject("name.invalid", "Please introduce the correct name, ex: <em>Name Surname</em>");
		}

	}

}
