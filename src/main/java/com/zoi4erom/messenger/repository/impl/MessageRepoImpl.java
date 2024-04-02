package com.zoi4erom.messenger.repository.impl;

import com.zoi4erom.messenger.entity.Message;
import com.zoi4erom.messenger.repository.RepoBase;
import com.zoi4erom.messenger.repository.contract.MessageRepo;
import jakarta.persistence.EntityManager;


public class MessageRepoImpl extends RepoBase<Long, Message> implements MessageRepo {

	private final EntityManager entityManager;

	public MessageRepoImpl(EntityManager entityManager) {
		super(entityManager, Message.class);
		this.entityManager = entityManager;
	}
}
