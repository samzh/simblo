package net.simblo.base.dao;

import java.util.Collection;

import net.simblo.base.util.HibernateTool;
import net.simblo.base.vo.ValueObject;

import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class HibernateBaseDao extends BaseDao {

	public HibernateBaseDao(Class clazz) {
		this._class = clazz;
	}

	private Class _class = null;

	public void set_class(Class _class) {
		this._class = _class;
	}

	public Class get_class() {
		return _class;
	}

	/**
	 * 保存VO
	 * 
	 * @throws Exception
	 */
	public void save(ValueObject vo) throws Exception {
		Session session = HibernateTool.getSession();
		session.beginTransaction();
		try {
			session.saveOrUpdate(vo);

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}

	/**
	 * 查找单个VO
	 * 
	 * @param id
	 * @return 与ID对应的VO
	 * @throws Exceptoin
	 */
	public ValueObject find(String id) throws Exception {
		return (ValueObject) HibernateTool.getSession().load(get_class(), id);
	}

	/**
	 * 返回所有VO
	 * 
	 * @return
	 * @throws Exception
	 */
	public Collection<ValueObject> queryAll() throws Exception {
		return null;
	}

	/**
	 * 删除VO
	 * 
	 * @param id
	 * @throws Exception
	 */
	@Transactional
	public void remove(String id) throws Exception {
		Session session = HibernateTool.getSession();
		session.beginTransaction();
		try {
			ValueObject vo = find(id);
			if (vo != null)
				session.delete(vo);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}

}
