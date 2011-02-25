package net.simblo.core.post.dao.impl;

import net.simblo.base.dao.BaseDao;
import net.simblo.core.post.dao.PostDAO;
import net.simblo.core.post.vo.Post;

import org.springframework.stereotype.Repository;

@Repository
public class PostDAOImpl extends BaseDao<Post> implements PostDAO {

	public PostDAOImpl() {
		super(Post.class);
	}

	public PostDAOImpl(Class<Post> clazz) {
		super(clazz);
	}

}
