package com.feedback.dto;

public class UserProfileExtended extends UserProfile{
	
	private String authority;

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "UserProfileA [authority=" + authority + "]";
	}
	
}
