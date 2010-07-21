package net.simblo.core.user.service.impl;

import net.simblo.core.user.dao.UserDAO;
import net.simblo.core.user.service.UserService;
import net.simblo.core.user.vo.User;

public class UserServiceImpl implements UserService {
	
	private UserDAO userDAO;

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public User find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
