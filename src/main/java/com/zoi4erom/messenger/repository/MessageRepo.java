package com.zoi4erom.messenger.repository;

import com.zoi4erom.messenger.entity.Message;
import org.hibernate.SessionFactory;

public class MessageRepo extends RepoBase<Long, Message>{
	private final SessionFactory sessionFactory;
	public MessageRepo(SessionFactory sessionFactory, Class<Message> clazz) {
		super(sessionFactory, clazz);
		this.sessionFactory = sessionFactory;
	}
}
