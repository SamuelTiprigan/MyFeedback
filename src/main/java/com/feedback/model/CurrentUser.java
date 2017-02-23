package com.feedback.model;

import org.springframework.security.core.authority.AuthorityUtils;

public class CurrentUser extends org.springframework.security.core.userdetails.User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private User user;

	public CurrentUser(User user) {
		super(user.getUsername(), user.getPassword(),
				AuthorityUtils.createAuthorityList(user.getAuthority().toString()));
		this.setUser(user);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return user.getAuthority();
	}
}
