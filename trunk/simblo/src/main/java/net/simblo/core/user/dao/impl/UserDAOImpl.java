package net.simblo.core.user.dao.impl;

import net.simblo.base.dao.BaseDao;
import net.simblo.core.user.dao.UserDAO;
import net.simblo.core.user.vo.User;

import org.springframework.stereotype.Repository;

@SuppressWarnings("rawtypes")
@Repository
public class UserDAOImpl extends BaseDao implements UserDAO {

	public UserDAOImpl() {
		super(User.class);
	}
}
