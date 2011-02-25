package net.simblo.core.comment.dao.impl;

import net.simblo.base.dao.BaseDao;
import net.simblo.core.comment.dao.CommentDAO;
import net.simblo.core.comment.vo.Comment;

import org.springframework.stereotype.Repository;

@Repository
public class CommentDAOImpl extends BaseDao<Comment> implements CommentDAO {
	public CommentDAOImpl() {
		super(Comment.class);
	}
}
