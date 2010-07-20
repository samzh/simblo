package net.simblo.core.user.dao.impl;

import net.simblo.base.dao.HibernateBaseDao;
import net.simblo.core.user.dao.UserDAO;

public class UserDAOImpl extends HibernateBaseDao implements UserDAO {

	public UserDAOImpl(Class clazz) {
		super(clazz);
	}

}
