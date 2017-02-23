package com.feedback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.feedback.dto.UserProfile;
import com.feedback.service.UserService;
import com.feedback.utils.ProfileUtil;

/**
 * @ResponseBody pentru a primi inapoi un json din java;
 * @RequestBody pentru a primi java din json;
 */

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView getProfile() {

		UserProfile profile = userService
				.getUserProfile(SecurityContextHolder.getContext().getAuthentication().getName());
		if (profile != null) {
			return ProfileUtil.getProfileModel(profile);
		}
		return new ModelAndView("error.load", "profile", profile);
	}

	@RequestMapping(path = "/updateProfile", method = RequestMethod.PUT)
	public ModelAndView updateProfile(@ModelAttribute UserProfile userProfile) {
		userService.updateUser(userProfile.getUsername(), userProfile);

		UserProfile profile = userService
				.getUserProfile(SecurityContextHolder.getContext().getAuthentication().getName());
		if (profile != null) {
			return ProfileUtil.getProfileModel(profile);
		}
		return new ModelAndView("error.fields", "profile", profile);
	}

	@RequestMapping(path = "/changePhoto", method = RequestMethod.PUT)
	public ModelAndView updatePhoto(@ModelAttribute UserProfile userProfile) {

		return null;
	}

}
