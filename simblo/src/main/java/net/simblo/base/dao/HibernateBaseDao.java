package net.simblo.base.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;

import net.simblo.base.action.ParamsTable;
import net.simblo.base.util.HibernateTool;

import org.hibernate.criterion.Projections;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class HibernateBaseDao<T> extends BaseDao<T> {

	private Class<T> clazz;

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
		HibernateTool.getSession().save(entity);

	}

	@Override
	public void delete(T entity) {
		HibernateTool.getSession().delete(entity);

	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(T entity) {
		entity = (T) HibernateTool.getSession().merge(entity);

	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(Serializable id) {
		return (T) HibernateTool.getSession().load(clazz, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		return HibernateTool.getSession().createCriteria(clazz).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findList(int pageNo, int pageSize) {
		return HibernateTool.getSession().createCriteria(clazz).setFirstResult((pageNo - 1) * pageSize)
				.setMaxResults(pageSize).list();
	}

	@Override
	public int getCountOfAll() {
		Integer count = (Integer) HibernateTool.getSession().createCriteria(clazz)
				.setProjection(Projections.rowCount()).uniqueResult();
		if (null == count) {
			return 0;
		} else {
			return count.intValue();
		}
	}
	
	@Override
	public Collection<T> queryByParams(ParamsTable params) {
		return null;
	}

	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}

	public Class<T> getClazz() {
		return clazz;
	}

}
