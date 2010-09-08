package net.simblo.core.post.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.simblo.base.controller.BaseAction;
import net.simblo.core.category.service.CategoryService;
import net.simblo.core.category.vo.Category;
import net.simblo.core.post.service.PostService;
import net.simblo.core.post.vo.Post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/post")
public class PostController extends BaseAction {

	private static Logger log = LoggerFactory.getLogger(PostController.class);

	@Autowired
	private PostService<Post> postService;

	@Autowired
	private CategoryService<Category> categoryService;

	public PostController() {
		super(new Post());
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("list")
	public ModelAndView doListAll() {
		Map map = new HashMap();
		map.put("dataList", postService.listAll());
		return new ModelAndView("/post/list", map);
	}

	@RequestMapping(value = "show/{id}", method = RequestMethod.GET)
	public ModelAndView doShow(@PathVariable long id) {
		Post post = (Post) postService.find(id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/post/show");
		if (post != null) {
			mav.addObject("content", post);
			return mav;
		}
		return mav;
	}

	@RequestMapping("new")
	public ModelAndView doNew() {
		List<Category> categoryList = categoryService.findAll();
		ModelMap map = new ModelMap();
		map.put("categoryList", categoryList);
		map.put("post", new Post());
		return new ModelAndView("/post/content", map);
	}

	@RequestMapping(method = RequestMethod.POST, value = "save")
	public ModelAndView doSave(HttpServletRequest request, Post post) {
		post.setCreated(new Date());
		post.setUpdated(new Date());
		System.out.println(post.getContent());
		String categoryId = request.getParameter("categoryselect");
		if (categoryId != null) {
			Category category = categoryService.find(Long.parseLong(categoryId));
			post.setCategory(category);
		}
		try {
			postService.save(post);
		} catch (Exception e) {
			log.info("What the hell! some troubles in posting! {}", e);
			return new ModelAndView("/post/content");
		}
		return new ModelAndView("redirect:/post/list");
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String doDelete(@PathVariable long id) {
		Post post = (Post) postService.find(id);
		try {
			postService.delete(post);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("删除出错: {}", e);
			return "redirect:/post/list";
		}
		return "redirect:/post/list";
	}

}
