package net.simblo.core.user.dao;

import java.util.Date;

import junit.framework.TestCase;
import net.simblo.core.user.vo.User;

public class UserDAOTest extends TestCase {
	
	public void testUserDAO() {
		UserDAO userDAO = new UserDAO();
		
		User user = new User();
		
		user.setCreated(new Date());
		user.setUpdated(new Date());
		user.setUserName("11111");
		user.setPassword("111111");
		try {
			userDAO.save(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
