package net.simblo.core.comment.dao.impl;

import net.simblo.base.dao.BaseDao;
import net.simblo.core.comment.dao.CommentDAO;
import net.simblo.core.comment.vo.Comment;

import org.springframework.stereotype.Repository;

@SuppressWarnings("rawtypes")
@Repository
public class CommentDAOImpl extends BaseDao implements CommentDAO {
	public CommentDAOImpl() {
		super(Comment.class);
	}
}
