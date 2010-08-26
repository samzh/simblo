package net.simblo.core.post.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import net.simblo.base.action.BaseAction;
import net.simblo.core.post.service.PostService;
import net.simblo.core.post.vo.Post;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings("serial")
@Namespace("/post")
public class PostAction extends BaseAction {

	@SuppressWarnings("rawtypes")
	@Autowired
	private PostService postService;

	public PostAction() {
		super(new Post());
	}

	@Action(value = "/list", results = { @Result(name = "success", location = "/post/list.jsp") })
	public String doListAll() {
		this.setDataList(postService.listAll());
		return SUCCESS;
	}

	@Action(value = "/new", results = { @Result(name = "success", location = "/post/new.jsp") })
	public String doNew() {
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	@Action(value = "/save", results = { @Result(name = "success", location = "/post/list", type = "redirect"),
			@Result(name = "input", location = "/post/new.jsp") })
	public String doSave() {
		Post post = (Post) this.getVo();
		post.setCreated(new Date());
		post.setUpdated(new Date());
		try {
			postService.save(post);
		} catch (Exception e) {
			LOG.info("What the hell! some troubles in posting! {}", e);
			return INPUT;
		}
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	@Action(value = "/delete", results = { @Result(name = "success", location = "/post/list", type = "redirect"),
			@Result(name = "input", location = "/post/list", type = "redirect") })
	public String doDelete() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		if (id != null) {
			Post post = (Post) postService.find(id);
			try {
				postService.delete(post);
			} catch (Exception e) {
				e.printStackTrace();
				LOG.error("删除出错: {}", e);
				return INPUT;
			}
		}
		return SUCCESS;
	}

}
