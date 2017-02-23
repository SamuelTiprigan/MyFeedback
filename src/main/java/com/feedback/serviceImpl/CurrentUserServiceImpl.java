package com.feedback.serviceImpl;

import org.springframework.stereotype.Service;

import com.feedback.model.CurrentUser;
import com.feedback.model.Role;
import com.feedback.service.CurrentUserService;

@Service
public class CurrentUserServiceImpl implements CurrentUserService {

	// obtain the username
	@Override
	public boolean canAccessUser(CurrentUser currentUser, Long userId) {
		return currentUser != null
				&& (currentUser.getRole() == Role.ROLE_ADMIN || currentUser.getUser().getId().equals(userId));
	}

}