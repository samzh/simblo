package net.simblo.core.index.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	private PostService postService;

	@Autowired
	private CategoryService categoryService;

	private int pageSize = 5;

	@RequestMapping(value = "/index")
	public ModelAndView doIndex(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String curPageStr = request.getParameter("curpage");
		int curPage = 1;
		if (curPageStr != null && !curPageStr.isEmpty()) {
			try {
				curPage = Integer.parseInt(curPageStr);
			} catch (Exception e) {
				logger.warn("页面参数错误，将使用默认页数: 1");
			}
		}

		ModelMap modelMap = new ModelMap();

		long totalCount = postService.getCount();

		List<Post> postList = postService.listTopPosts(curPage, pageSize);

		List<Category> categoryList = categoryService.findAll();

		modelMap.put("postList", postList);

		modelMap.put("totalCount", totalCount);

		modelMap.put("categoryList", categoryList);

		return new ModelAndView("/index", modelMap);
	}

}
