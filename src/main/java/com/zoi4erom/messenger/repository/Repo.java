package com.zoi4erom.messenger.repository;

import com.zoi4erom.messenger.entity.BaseEntity;
import java.io.Serializable;
import java.util.List;

public interface Repo<K extends Serializable, E extends BaseEntity> {
	void create(E e);
	List<E> getAll();
	E getById(K k);
	void update(E e);
	void delete(K k);
}
