package com.zoi4erom.messenger.repository;

import com.zoi4erom.messenger.entity.Chat;
import org.hibernate.SessionFactory;

public class ChatRepo extends RepoBase<Integer, Chat>{
	private final SessionFactory sessionFactory;
	public ChatRepo(SessionFactory sessionFactory, Class<Chat> clazz) {
		super(sessionFactory, clazz);
		this.sessionFactory = sessionFactory;
	}
}
