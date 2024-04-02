package com.zoi4erom.messenger.service;

import com.zoi4erom.messenger.dto.UserReadDto;
import com.zoi4erom.messenger.entity.User;
import com.zoi4erom.messenger.mapper.UserReadMapper;
import com.zoi4erom.messenger.repository.impl.UserRepoImpl;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("userService")
@RequiredArgsConstructor
public class UserService {
	private final UserRepoImpl userRepoImpl;
	private final UserReadMapper userReadMapper;

	public void createUser(String login, String email, String password) {
		User user = new User(login, password, email);
		userRepoImpl.create(user);
	}

	public Optional<UserReadDto> getUserByLogin(String login) {
		return userRepoImpl.getUserByLogin(login)
		    .map(userReadMapper::mapFrom)
		    .map(Optional::ofNullable)
		    .orElse(Optional.empty());
	}
}
