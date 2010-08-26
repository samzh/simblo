package net.simblo.base.service;

import java.util.List;

public interface IService<T> {

	void save(T t);

	void delete(T t);

	T find(String id);

	List<T> findAll();

}
