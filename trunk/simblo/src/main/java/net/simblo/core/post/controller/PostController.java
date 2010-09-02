package net.simblo.core.post.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.simblo.base.controller.BaseAction;
import net.simblo.core.post.service.PostService;
import net.simblo.core.post.vo.Post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/post")
public class PostController extends BaseAction {

	private static Logger log = LoggerFactory.getLogger(PostController.class);

	@SuppressWarnings("rawtypes")
	@Autowired
	private PostService postService;

	public PostController() {
		super(new Post());
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("list")
	public ModelAndView doListAll() {
		Map map = new HashMap();
		map.put("dataList", postService.listAll());

		return new ModelAndView("list", map);
	}

	@RequestMapping("new")
	public String doNew() {
		return "new";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(method = RequestMethod.POST, value = "save")
	public ModelAndView doSave() {
		Post post = (Post) this.getVo();
		post.setCreated(new Date());
		post.setUpdated(new Date());
		try {
			postService.save(post);
		} catch (Exception e) {
			log.info("What the hell! some troubles in posting! {}", e);
			return new ModelAndView("new");
		}
		return new ModelAndView("redirect:/post/list");
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("delete")
	public String doDelete(HttpServletRequest request) {
		String id = request.getParameter("id");
		if (id != null) {
			Post post = (Post) postService.find(id);
			try {
				postService.delete(post);
			} catch (Exception e) {
				e.printStackTrace();
				log.error("删除出错: {}", e);
				return "redirect:/post/list";
			}
		}
		return "redirect:/post/list";
	}

}
