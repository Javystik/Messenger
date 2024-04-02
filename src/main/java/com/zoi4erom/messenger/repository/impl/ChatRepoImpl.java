package com.zoi4erom.messenger.repository.impl;

import com.zoi4erom.messenger.entity.Chat;
import com.zoi4erom.messenger.repository.RepoBase;
import com.zoi4erom.messenger.repository.contract.ChatRepo;
import jakarta.persistence.EntityManager;


public class ChatRepoImpl extends RepoBase<Integer, Chat> implements ChatRepo {

	private final EntityManager entityManager;

	public ChatRepoImpl(EntityManager entityManager) {
		super(entityManager, Chat.class);
		this.entityManager = entityManager;
	}
}
