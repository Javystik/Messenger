package com.zoi4erom.messenger.service;

import com.zoi4erom.messenger.entity.User;

public class AuthenticationService {
	private final UserService userService;

	public AuthenticationService(UserService userService) {
		this.userService = userService;
	}
	public boolean authentication(String login, String password){
		var userByLogin = userService.getUserByLogin(login);

		if(userByLogin != null && userByLogin.getPassword().equals(password)){
			return true;
		}
		return false;
	}

}
