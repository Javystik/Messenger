package com.zoi4erom.messenger.repository;

import com.zoi4erom.messenger.entity.BaseEntity;
import jakarta.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class RepoBase<K extends Serializable, E extends BaseEntity> implements Repo<K, E> {

	private final EntityManager entityManager;

	private final Class<E> clazz;

	public RepoBase(EntityManager entityManager, Class<E> clazz) {
		this.entityManager = entityManager;
		this.clazz = clazz;
	}

	@Override
	public void create(E e) {
		entityManager.persist(e);
	}

	@Override
	public List<E> getAll() {
		return entityManager.createQuery("from " + clazz.getSimpleName(), clazz)
		    .getResultList();
	}

	@Override
	public Optional<E> getById(K id) {
		return Optional.ofNullable(entityManager.find(clazz, id));
	}

	@Override
	public void update(E e) {
		entityManager.merge(e);
	}

	@Override
	public void delete(K id) {
		Optional<E> entity = getById(id);
		if (entity.isPresent()) {
			entityManager.remove(entity);
		}
	}
}