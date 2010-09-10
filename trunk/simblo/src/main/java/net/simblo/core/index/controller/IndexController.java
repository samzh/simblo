package net.simblo.core.index.controller;

import java.util.List;

import net.simblo.base.controller.BaseAction;
import net.simblo.base.vo.ValueObject;
import net.simblo.core.category.service.CategoryService;
import net.simblo.core.category.vo.Category;
import net.simblo.core.post.service.PostService;
import net.simblo.core.post.vo.Post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController extends BaseAction {

	public IndexController() {
		super(new ValueObject());
	}

	private Logger logger = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private PostService<Post> postService;

	@Autowired
	private CategoryService<Category> categoryService;

	@RequestMapping(value = "/index")
	public ModelAndView doIndex() throws Exception {

		ModelMap modelMap = new ModelMap();

		List<Post> postList = postService.findAll();

		List<Category> categoryList = categoryService.findAll();

		modelMap.put("postList", postList);

		modelMap.put("categoryList", categoryList);

		return new ModelAndView("/index", modelMap);
	}

}
