package net.simblo.base.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

public class HibernateBaseDao<T> extends BaseDao<T> {

	private EntityManager em;

	private Class<T> clazz;

	private final String SQL = "select c from " + clazz.getName() + " c";

	@SuppressWarnings("unchecked")
	public HibernateBaseDao() {
		// 通过反射获取T的类型信息实例
		this.setClazz((Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
	}

	public HibernateBaseDao(Class<T> clazz) {
		this.clazz = clazz;
	}

	@Override
	public void create(T entity) {
		em.persist(entity);

	}

	@Override
	public void delete(T entity) {
		em.remove(entity);

	}

	@Override
	public void update(T entity) {
		em.merge(entity);

	}

	@Override
	public T get(Serializable id) {
		return (T) em.find(clazz, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		return em.createQuery(SQL).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findList(int pageNo, int pageSize) {
		return em.createQuery(SQL).setFirstResult((pageNo - 1) * pageSize).setMaxResults(pageSize).getResultList();
	}

	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}

	public Class<T> getClazz() {
		return clazz;
	}

}
