package net.simblo.core.user.dao;

import java.util.Date;

import net.simblo.core.user.vo.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "text-Context.xml" })
public class UserDAOTest extends AbstractTransactionalJUnit4SpringContextTests {

	@SuppressWarnings("rawtypes")
	@Autowired
	private UserDAO userDAO;

	@SuppressWarnings("unchecked")
	@Transactional
	@Test
	public void testInsert() {
		User user = new User();
		user.setUserName("中文测试");
		user.setPassword("1111111");
		user.setCreated(new Date());
		user.setUpdated(new Date());
		userDAO.persist(user);
		System.out.println(userDAO.queryAll().size());
	}

}
