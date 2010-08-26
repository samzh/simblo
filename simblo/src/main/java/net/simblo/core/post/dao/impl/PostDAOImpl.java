package net.simblo.core.post.dao.impl;

import org.springframework.stereotype.Repository;

import net.simblo.base.dao.BaseDao;
import net.simblo.core.post.dao.PostDAO;
import net.simblo.core.post.vo.Post;

@SuppressWarnings("rawtypes")
@Repository
public class PostDAOImpl extends BaseDao implements PostDAO {

	public PostDAOImpl() {
		super(Post.class);
	}

	public PostDAOImpl(Class<Post> clazz) {
		super(clazz);
	}

}
