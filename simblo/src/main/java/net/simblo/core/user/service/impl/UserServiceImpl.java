package net.simblo.core.user.service.impl;

import java.util.List;

import net.simblo.core.user.dao.UserDAO;
import net.simblo.core.user.service.UserService;
import net.simblo.core.user.vo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	@Transactional
	public void persist(User t) {
		userDAO.persist(t);
	}

	@Override
	@Transactional
	public void remove(User t) {
		userDAO.remove(t);
	}

	@Override
	public User find(long id) {

		return (User) userDAO.find(id);
	}

	@Override
	public List<User> findAll() {
		return userDAO.queryAll();
	}

	@Override
	public User findByName(String name) {
		// TODO 等待DAO层根据参数查询方法完成
		return null;
	}

	@Override
	public long getCount() {
		return userDAO.getCount();
	}

}
