package com.zoi4erom.messenger.repository.impl;

import com.zoi4erom.messenger.entity.User;
import com.zoi4erom.messenger.repository.RepoBase;
import com.zoi4erom.messenger.repository.contract.UserRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepoImpl extends RepoBase<Integer, User> implements UserRepo {
	private final EntityManager entityManager;
	public UserRepoImpl(EntityManager entityManager) {
		super(entityManager, User.class);
		this.entityManager = entityManager;
	}

	@Override
	public Optional<User> getUserByLogin(String login) {
		try {
			User user = entityManager.createQuery("SELECT u FROM User u WHERE u.login = :login", User.class)
			    .setParameter("login", login)
			    .getSingleResult();
			return Optional.ofNullable(user);
		} catch (NoResultException e) {
			return Optional.empty();
		}
	}
}
