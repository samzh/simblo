package net.simblo.core.post.service.impl;

import java.util.List;

import net.simblo.core.post.dao.PostDAO;
import net.simblo.core.post.service.PostService;
import net.simblo.core.post.vo.Post;

public class PostServiceImpl implements PostService {
	
	private PostDAO postDAO;

	@Override
	public List<Post> listTopPosts(int count) {
		return null;
	}

}
