package net.simblo.core.post.dao.impl;

import net.simblo.base.dao.HibernateBaseDao;
import net.simblo.core.post.dao.PostDAO;
import net.simblo.core.post.vo.Post;

public class PostDAOImpl extends HibernateBaseDao<Post> implements PostDAO {
	
	public PostDAOImpl() {
		super(Post.class);
	}

	public PostDAOImpl(Class<Post> clazz) {
		super(clazz);
	}

}
