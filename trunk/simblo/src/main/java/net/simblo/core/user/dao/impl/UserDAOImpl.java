package net.simblo.core.user.dao.impl;

import org.springframework.stereotype.Repository;

import net.simblo.base.dao.BaseDao;
import net.simblo.core.user.vo.User;

@Repository
public class UserDAOImpl extends BaseDao<User> {

	public UserDAOImpl() {
		super(User.class);
	}
}
