package net.simblo.base.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import net.simblo.base.vo.ValueObject;

@Repository
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
	public void persist(T entity) {
		em.persist(entity);

	}

	@Override
	public void remove(T entity) {
		em.remove(entity);

	}

	@Override
	public void merge(T entity) {
		em.merge(entity);

	}

	@SuppressWarnings("unchecked")
	@Override
	public T find(Serializable id) {
		return (T) em.find(clazz, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> queryAll() {
		return em.createQuery("select t from " + clazz.getSimpleName() + " t").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> queryList(int pageNo, int pageSize) {
		return em.createQuery("select t from " + this.clazz.getName() + " t")
				.setFirstResult((pageNo - 1) * pageSize).setMaxResults(pageSize).getResultList();
	}
	
	public long getCount() {
		return (Long)em.createQuery("select count(*) from " + this.clazz.getSimpleName()).getSingleResult();
	}

}
