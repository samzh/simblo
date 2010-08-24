package net.simblo.core.user.service.impl;

import net.simblo.core.user.dao.UserDAO;
import net.simblo.core.user.service.UserService;
import net.simblo.core.user.vo.User;

import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

	@SuppressWarnings("rawtypes")
	@Autowired
	private UserDAO userDAO;

	@Override
	public void save(User user) {
		try {
			userDAO.create(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(User user) {
		try {
			userDAO.delete(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public User find(String id) throws Exception {
		try {
			return (User) userDAO.get(id);
		} catch (Exception e) {
			throw new Exception("User not found");
		}
	}

	@Override
	public User findByName(String name) {

		return null;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
