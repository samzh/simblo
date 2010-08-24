package net.simblo.core.user.dao;

import java.util.Date;

import junit.framework.TestCase;
import net.simblo.core.user.dao.impl.UserDAOImpl;
import net.simblo.core.user.vo.User;

public class UserDAOTest extends TestCase {

	public void testUserDAO() {
		UserDAOImpl userDAO = new UserDAOImpl();

		User user = new User();

		user.setCreated(new Date());
		user.setUpdated(new Date());
		user.setUserName("11111");
		user.setPassword("111111");
		try {
			userDAO.create(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
