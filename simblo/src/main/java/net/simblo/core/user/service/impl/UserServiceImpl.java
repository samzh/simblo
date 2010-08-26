package net.simblo.core.user.service.impl;

import java.util.List;

import net.simblo.core.user.dao.UserDAO;
import net.simblo.core.user.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class UserServiceImpl<User> implements UserService<User> {

	@SuppressWarnings("rawtypes")
	@Autowired
	private UserDAO userDAO;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public void save(User t) {
		userDAO.create(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public void delete(User t) {
		userDAO.delete(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public User find(String id) {

		return (User) userDAO.get(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		return userDAO.findAll();
	}

	@Override
	public User findByName(String name) {
		// TODO 等待DAO层根据参数查询方法完成
		return null;
	}

}
