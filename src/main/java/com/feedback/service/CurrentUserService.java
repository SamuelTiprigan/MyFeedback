package com.feedback.service;

import com.feedback.model.CurrentUser;

public interface CurrentUserService {
	
	boolean canAccessUser(CurrentUser currentUser, Long userId);
}
