package net.simblo.core.comment.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.simblo.base.vo.ValueObject;
import net.simblo.core.post.vo.Post;

@Entity
@Table(name = "si_comment")
/**
 * 评论类，每个Post可以有若干个评论
 */
public class Comment extends ValueObject {

	private String title;

	private String authorName;

	private String content;

	private Post post;

	public void setContent(String content) {
		this.content = content;
	}

	@Lob
	@Column(name = "content", length = 500000)
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

	public void setPost(Post post) {
		this.post = post;
	}

	@ManyToOne(targetEntity = Post.class)
	public Post getPost() {
		return post;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	@Column(name = "author_name")
	public String getAuthorName() {
		return authorName;
	}

}
