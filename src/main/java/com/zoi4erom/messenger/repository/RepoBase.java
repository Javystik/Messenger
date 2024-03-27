package com.zoi4erom.messenger.repository;

import com.zoi4erom.messenger.entity.BaseEntity;
import java.io.Serializable;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;

@RequiredArgsConstructor
public abstract class RepoBase<K extends Serializable, E extends BaseEntity> implements Repo<K, E> {

	private final SessionFactory sessionFactory;

	private final Class<E> clazz;

	@Override
	public void create(E e) {
		try (var session = sessionFactory.openSession()) {
			session.persist(e);
		}
	}

	@Override
	public List<E> getAll() {
		try (var session = sessionFactory.openSession()) {
			return session.createQuery("from " + clazz.getSimpleName(), clazz).getResultList();
		}
	}

	@Override
	public E getById(K id) {
		try (var session = sessionFactory.openSession()) {
			return session.get(clazz, id);
		}
	}

	@Override
	public void update(E e) {
		try (var session = sessionFactory.openSession()) {
			session.persist(e);
		}
	}

	@Override
	public void delete(K id) {
		try (var session = sessionFactory.openSession()) {
			session.remove(id);
		}
	}
}
