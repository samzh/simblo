package net.simblo.base.service;

import java.util.List;

public interface IService<T> {

	void save(T t);

	void delete(T t);

	T find(long id);

	List<T> findAll();

	long getCount();

}
