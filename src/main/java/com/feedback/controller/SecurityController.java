package com.feedback.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {
		
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping("/test")
	public String getMainPage(Authentication authentication) {
	    UserDetails currentUser = (UserDetails) authentication.getPrincipal();
	    
	    System.out.println(authentication.getPrincipal().toString());
		System.out.println("Security = " + SecurityContextHolder.getContext().getAuthentication().getAuthorities());

		System.out.println("Authorities = "+currentUser.getAuthorities().toString());
		
	    UserDetails userDetails = (UserDetails) authentication.getPrincipal();
	    System.out.println("User has authorities: " + userDetails.getAuthorities());
		return "admin/admin";
	}
}