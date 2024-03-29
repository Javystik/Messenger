package com.zoi4erom.messenger.repository;

import com.zoi4erom.messenger.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UserRepo extends RepoBase<Integer, User>{
	private final SessionFactory sessionFactory;

	public UserRepo(SessionFactory sessionFactory) {
		super(sessionFactory, User.class);
		this.sessionFactory = sessionFactory;
	}
	public User getUserByLogin(String login){
		try (var currentSession = sessionFactory.getCurrentSession()) {
			currentSession.beginTransaction();

			var user = currentSession.createQuery("from User WHERE login = :login", User.class)
			    .setParameter("login", login)
			    .uniqueResult();

			currentSession.getTransaction().commit();

			return user;
		}
	}
}
