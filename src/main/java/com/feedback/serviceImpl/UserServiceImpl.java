package com.feedback.serviceImpl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.feedback.dto.UserCreateForm;
import com.feedback.dto.UserProfile;
import com.feedback.model.User;
import com.feedback.repository.UserRepository;
import com.feedback.service.UserService;
import com.feedback.utils.Utils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public Collection<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(long id) {
		return userRepository.getById(id);
	}

	@Override
	public User getUserByEmail(String email) {
		return userRepository.getByEmail(email);
	}

	@Override
	public void createUser(UserCreateForm form) {
		User user = new User();
		user.setEmail(form.getEmail());
		user.setName(form.getName());
		user.setUsername(Utils.optainUsername(form.getEmail()));
		user.setEnabled(true);
		user.setAuthority(form.getRole());
		user.setPassword(new BCryptPasswordEncoder().encode(form.getPasswordRepeated()));
		user.setAddress(form.getAddress());
		user.setPhoneNo(form.getPhoneNo());
		user.setImgPath(form.getImgPath());
		userRepository.createUser(user);
	}

	@Override
	public User getUserByUsername(String username) {
		return userRepository.getUserByUsername(username);
	}

	@Override
	public UserProfile getUserProfile(String username) {
		User user = this.userRepository.getUserByUsername(username);

		UserProfile profile = new UserProfile();

		profile.setName(user.getName());
		profile.setUsername(user.getUsername());
		profile.setPhoneNo(user.getPhoneNo());
		profile.setAddress(user.getAddress());
		profile.setEmail(user.getEmail());

		if (!user.getImgPath().equals("default")) {
			profile.setImgPath(user.getImgPath());
		} else {
			profile.setImgPath("/default/defaultImg.png");
		}

		return profile;
	}

	@Override
	public void updateUser(String username, UserProfile profile) {
		User existingUser = this.userRepository.getUserByUsername(username);
		System.out.println("existing " + existingUser.toString());

		if (existingUser != null) {
			existingUser.setEmail(profile.getEmail());
			existingUser.setName(profile.getName());
			existingUser.setImgPath(profile.getImgPath());
			existingUser.setPhoneNo(profile.getPhoneNo());
			existingUser.setUsername(profile.getUsername());
			userRepository.updateUser(existingUser);
		}

	}

}