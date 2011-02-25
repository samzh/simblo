package net.simblo.core.comment.service.impl;

import java.util.List;

import net.simblo.core.comment.dao.CommentDAO;
import net.simblo.core.comment.service.CommentService;
import net.simblo.core.comment.vo.Comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDAO commentDAO;

	@Override
	@Transactional
	public void persist(Comment t) {
		commentDAO.persist(t);

	}

	@Override
	@Transactional
	public void remove(Comment t) {
		commentDAO.remove(t);

	}

	@Override
	public Comment find(long id) {

		return (Comment) commentDAO.find(id);
	}

	@Override
	public List<Comment> findAll() {

		return commentDAO.queryAll();
	}

	@Override
	public long getCount() {
		return commentDAO.getCount();
	}

}
