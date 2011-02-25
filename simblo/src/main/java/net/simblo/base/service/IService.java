package net.simblo.base.service;

import java.util.List;

public interface IService<T> {

	void persist(T t);

	void remove(T t);

	T find(long id);

	List<T> findAll();

	long getCount();

}
