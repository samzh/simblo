package net.simblo.core.user.dao;

import net.simblo.base.dao.HibernateBaseDao;
import net.simblo.core.user.vo.User;

public class UserDAO extends HibernateBaseDao<User> {

	public UserDAO() {
		super(User.class);
	}

	public UserDAO(Class<User> clazz) {
		super(clazz);
	}

}
