package com.zoi4erom.messenger.repository.impl;

import com.zoi4erom.messenger.entity.Friend;
import com.zoi4erom.messenger.repository.RepoBase;
import com.zoi4erom.messenger.repository.contract.FriendRepo;
import jakarta.persistence.EntityManager;


public class FriendRepoImpl extends RepoBase<Integer, Friend> implements FriendRepo {

	private final EntityManager entityManager;

	public FriendRepoImpl(EntityManager entityManager) {
		super(entityManager, Friend.class);
		this.entityManager = entityManager;
	}
}
