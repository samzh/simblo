package net.simblo.core.comment.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import net.simblo.base.vo.ValueObject;
import net.simblo.core.user.vo.User;

@Entity
@Table(name = "si_comment")
/**
 * 评论类，每个Post可以有若干个评论
 */
public class Comment extends ValueObject {

	private String title;

	private User author;

	private String content;

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "content")
	public String getContent() {
		return content;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "title")
	public String getTitle() {
		return title;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	@OneToOne(targetEntity = User.class)
	public User getAuthor() {
		return author;
	}

}
