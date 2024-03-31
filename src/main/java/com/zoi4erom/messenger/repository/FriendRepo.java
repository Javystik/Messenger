package com.zoi4erom.messenger.repository;

import com.zoi4erom.messenger.entity.Friend;
import org.hibernate.SessionFactory;

public class FriendRepo extends RepoBase<Integer, Friend> {
	private final SessionFactory sessionFactory;
	public FriendRepo(SessionFactory sessionFactory, Class<Friend> clazz) {
		super(sessionFactory, clazz);
		this.sessionFactory = sessionFactory;
	}
}
