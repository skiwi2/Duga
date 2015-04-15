package com.skiwi.githubhooksechatservice.service;

import com.skiwi.githubhooksechatservice.dao.UserDAO;
import com.skiwi.githubhooksechatservice.model.DugaUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;

	public DugaUser getUser(String login) {
		return userDAO.getUser(login);
	}

	@Override
	public void createUser(String username, String password) {
		userDAO.createUser(username, password);
	}

	@Override
	public DugaUser getAuthenticatedUser() {
		return getUser(SecurityContextHolder.getContext().getAuthentication().getName());
	}
}
