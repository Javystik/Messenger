package com.zoi4erom.messenger.repository;

import com.zoi4erom.messenger.entity.BaseEntity;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface Repo<K extends Serializable, E extends BaseEntity> {
	void create(E e);
	List<E> getAll();
	Optional<E> getById(K k);
	void update(E e);
	void delete(K k);
}
