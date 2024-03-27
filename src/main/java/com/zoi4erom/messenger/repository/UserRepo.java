package com.zoi4erom.messenger.repository;

import com.zoi4erom.messenger.entity.User;
import org.hibernate.SessionFactory;

public class UserRepo extends RepoBase<Integer, User>{

	public UserRepo(SessionFactory sessionFactory) {
		super(sessionFactory, User.class);
	}
}
