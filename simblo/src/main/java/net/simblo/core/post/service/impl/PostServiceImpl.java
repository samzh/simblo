package net.simblo.core.post.service.impl;

import java.util.List;

import net.simblo.core.post.dao.PostDAO;
import net.simblo.core.post.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostServiceImpl<Post> implements PostService<Post> {

	@SuppressWarnings("rawtypes")
	@Autowired
	private PostDAO postDAO;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public void save(Post t) {
		postDAO.create(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public void delete(Post t) {
		postDAO.delete(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Post find(long id) {
		return (Post) postDAO.get(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Post> findAll() {
		return postDAO.findAll();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Post> listTopPosts(int count) {
		return postDAO.findList(0, count);
	}

	@Override
	public List<Post> listAll() {
		return findAll();
	}

}
