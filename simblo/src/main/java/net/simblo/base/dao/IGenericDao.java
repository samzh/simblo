package net.simblo.base.dao;

import java.io.Serializable;
import java.util.List;

/**
 * 泛型通用DAO接口
 * 
 * @author Sam
 * 
 * @param <T>
 */
public interface IGenericDao<T> {

	void persist(T entity);

	void remove(T entity);

	void merge(T entity);

	T find(Serializable id);

	List<T> queryAll();

	List<T> queryList(int pageNo, int pageSize);
	
	long getCount();

}
