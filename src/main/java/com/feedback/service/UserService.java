package com.feedback.service;

import java.util.Collection;

import com.feedback.dto.UserCreateForm;
import com.feedback.dto.UserProfile;
import com.feedback.model.User;

public interface UserService {

	User getUserById(long id);

	User getUserByEmail(String email);

	Collection<User> getAllUsers();

	void createUser(UserCreateForm form);

	User getUserByUsername(String username);

	UserProfile getUserProfile(String username);
	
	void updateUser(String username, UserProfile profile);

}