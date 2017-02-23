package com.feedback.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.feedback.model.Role;

public class UserCreateForm {

	@NotEmpty(message = "Please enter your email addresss.")
	@Email(message = "Please check the email address!")
	private String email = "";

	@NotEmpty(message = "Please enter your Name.")
	@Size(min = 2, max = 30, message = "Password length must be between 2 and 30 characters !")
	private String name = "";

	@NotEmpty(message = "Please enter your password.")
	@Size(min = 6, max = 30, message = "Password length must be between 6 and 30 characters !")
	private String password = "";

	@NotEmpty(message = "Please confirm your password.")
	@Size(min = 6, max = 30, message = "Password length must be between 6 and 30 characters !")
	private String passwordRepeated = "";

	@NotEmpty(message = "Please enter your phoneNo!")
	@Size(min = 6, max = 15, message = "Phone Number cannot has to be between 6 and 15 characters !")
	private String phoneNo;

	@NotEmpty(message = "Please enter your address !")
	@Size(min = 6, max = 100, message = "Address length must be between 6 and 30 characters !")
	private String address;

	@NotNull
	private Role role = Role.ROLE_ADMIN;

	@NotNull
	private String imgPath = "default";

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordRepeated() {
		return passwordRepeated;
	}

	public void setPasswordRepeated(String passwordRepeated) {
		this.passwordRepeated = passwordRepeated;
	}

	@Override
	public String toString() {
		return "UserCreateForm [email=" + email + ",name=" + name + ", password=" + password.hashCode()
				+ ", passwordRepeated=" + passwordRepeated.hashCode() + ", role=" + role + "]";
	}

}