package net.simblo.core.post.service.impl;

import java.util.List;

import net.simblo.core.post.dao.PostDAO;
import net.simblo.core.post.service.PostService;
import net.simblo.core.post.vo.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostDAO<Post> postDAO;

	@Override
	@Transactional
	public void save(Post t) {
		postDAO.create(t);
	}

	@Override
	@Transactional
	public void delete(Post t) {
		postDAO.delete(t);
	}

	@Override
	public Post find(long id) {
		return (Post) postDAO.get(id);
	}

	@Override
	public List<Post> findAll() {
		return postDAO.findAll();
	}

	@Override
	public List<Post> listTopPosts(int currpage, int pageSize) {
		return postDAO.findList(currpage, pageSize);
	}

	@Override
	public List<Post> listAll() {
		return findAll();
	}
	
	@Override
	public long getCount() {
		return postDAO.getCount();
	}

}
