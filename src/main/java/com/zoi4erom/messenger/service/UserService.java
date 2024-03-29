package com.zoi4erom.messenger.service;

import com.zoi4erom.messenger.entity.User;
import com.zoi4erom.messenger.repository.UserRepo;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UserService {
	private final SessionFactory sessionFactory;
	private final UserRepo userRepo;
	public UserService() {
		this.sessionFactory = new Configuration()
		    .configure()
		    .addAnnotatedClass(User.class)
		    .buildSessionFactory();
		this.userRepo = new UserRepo(sessionFactory);
	}
	public void createUser(String login, String email, String password){
		User user = new User(login, password, email);
		userRepo.create(user);
	}
	public User getUserByLogin(String login){
		return userRepo.getUserByLogin(login);
	}
}
