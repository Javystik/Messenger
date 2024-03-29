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
			session.beginTransaction();
			session.persist(e);
			session.getTransaction().commit();
		}

	}

	@Override
	public List<E> getAll() {
		try (var session = sessionFactory.openSession()) {
			session.beginTransaction();
			var entityList = session.createQuery("from " + clazz.getSimpleName(), clazz)
			    .getResultList();
			session.getTransaction().commit();
			return entityList;
		}
	}

	@Override
	public E getById(K id) {
		try (var session = sessionFactory.openSession()) {
			session.beginTransaction();
			var entity = session.get(clazz, id);
			session.getTransaction().commit();
			return entity;
		}
	}

	@Override
	public void update(E e) {
		try (var session = sessionFactory.openSession()) {
			session.beginTransaction();
			session.persist(e);
			session.getTransaction().commit();
		}
	}

	@Override
	public void delete(K id) {
		try (var session = sessionFactory.openSession()) {
			session.beginTransaction();
			session.remove(id);
			session.getTransaction().commit();
		}
	}
}
