package net.simblo.core.post.vo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import net.simblo.base.vo.ValueObject;
import net.simblo.core.comment.vo.Comment;
import net.simblo.core.user.vo.User;

@Entity
@Table(name = "si_post")
public class Post extends ValueObject {

	private String title;

	private String content;

	private User author;

	private List<Comment> comment;

	@Column(name = "title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Lob
	@Column(name = "content", length= 500000)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@OneToOne(targetEntity = User.class)
	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	@Column(name = "closed")
	public boolean isClosed() {
		return closed;
	}

	public void setClosed(boolean closed) {
		this.closed = closed;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

	@OneToMany(targetEntity = Comment.class)
	public List<Comment> getComment() {
		return comment;
	}

	private boolean closed;

}
