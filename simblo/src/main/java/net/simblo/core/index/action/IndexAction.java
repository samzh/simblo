package net.simblo.core.index.action;

import java.util.List;

import net.simblo.base.action.BaseAction;
import net.simblo.core.post.service.PostService;
import net.simblo.core.post.vo.Post;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

@SuppressWarnings("serial")
public class IndexAction extends BaseAction {
	/**
	 * 返回组装内容后的主页
	 * 
	 * @return
	 * @throws Exception
	 */
	
	private PostService postService;
	
	@SuppressWarnings("unchecked")
	@Action(results = { @Result(name = "success", location = "/index.jsp") })
	public String doIndex() throws Exception {
		List<Post> postList = postService.listTopPosts(10);
		getDataMap().put("POSTLIST", postList);
		return SUCCESS;
	}

	public void setPostService(PostService postService) {
		this.postService = postService;
	}
}
