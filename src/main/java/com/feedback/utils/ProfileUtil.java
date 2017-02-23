package com.feedback.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;

import com.feedback.dto.UserProfile;

public class ProfileUtil {

	public static ModelAndView getProfileModel(UserProfile profile) {

		ModelAndView model = new ModelAndView("profile");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication.getName() != null) {
			model.addObject("username", authentication.getName());
			model.addObject("name", profile.getName());
			model.addObject("email", profile.getEmail());
			model.addObject("address", profile.getAddress());
			model.addObject("phoneNo", profile.getPhoneNo());
			model.addObject("imgPath", profile.getImgPath());
			return model;
		}
		return new ModelAndView("errors");
	}
}
