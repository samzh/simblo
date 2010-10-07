package net.simblo.core.comment.service.impl;

import java.util.List;

import net.simblo.core.comment.dao.CommentDAO;
import net.simblo.core.comment.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentServiceImpl<Comment> implements CommentService<Comment> {
	
	@SuppressWarnings("rawtypes")
	@Autowired
	private CommentDAO commentDAO;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public void save(Comment t) {
		commentDAO.create(t);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public void delete(Comment t) {
		commentDAO.delete(t);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public Comment find(long id) {
		
		return (Comment)commentDAO.get(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> findAll() {
		
		return commentDAO.findAll();
	}

	@Override
	public long getCount() {
		return commentDAO.getCount();
	}

	

}
