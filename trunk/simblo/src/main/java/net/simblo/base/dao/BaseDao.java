package net.simblo.base.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.simblo.base.vo.ValueObject;

public class BaseDao<T> implements IDao, IGenericDao<T> {

	private Class<? extends ValueObject> clazz;

	public BaseDao(ValueObject vo) {
		this.clazz = vo.getClass();
	}

	@SuppressWarnings("unchecked")
	public BaseDao(@SuppressWarnings("rawtypes") Class clazz) {
		this.clazz = clazz;
	}

	public BaseDao() {
	}

	@PersistenceContext
	private EntityManager em;

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

	@SuppressWarnings("unchecked")
	@Override
	public T get(Serializable id) {
		return (T) em.find(clazz, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		return em.createNativeQuery("select t from " + this.clazz.getName() + " t", clazz).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findList(int pageNo, int pageSize) {
		return em.createNativeQuery("select t from " + this.clazz.getName() + " t", clazz)
				.setFirstResult((pageNo - 1) * pageSize).setMaxResults(pageSize).getResultList();
	}

}
