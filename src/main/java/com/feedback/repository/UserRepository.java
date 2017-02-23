package com.feedback.repository;

import java.util.Collection;

import com.feedback.model.User;

public interface UserRepository {

	User getById(long id);

	User getByEmail(String email);

	Collection<User> findAll();

	void createUser(User user);

	User getUserByUsername(String username);

	void updateUser(User user);
}