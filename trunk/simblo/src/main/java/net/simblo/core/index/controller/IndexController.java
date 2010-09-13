package net.simblo.core.index.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.simblo.base.controller.BaseAction;
import net.simblo.base.vo.ValueObject;
import net.simblo.core.category.service.CategoryService;
import net.simblo.core.category.vo.Category;
import net.simblo.core.post.service.PostService;
import net.simblo.core.post.vo.Post;

import org.apache.catalina.util.ParameterMap;
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

	
	private int pageSize = 5;
	
	@RequestMapping(value = "/index")
	public ModelAndView doIndex(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ParameterMap map = (ParameterMap)request.getParameterMap();
		
		for (Iterator iter = map.keySet().iterator();iter.hasNext();) {
			String key = (String)iter.next();
			
			logger.info(key);
			logger.info((String) map.get(key));
		}
		
		
//		if (curPage != null && !curPage.isEmpty()) {
//			
//		}

		ModelMap modelMap = new ModelMap();

		List<Post> postList = postService.listTopPosts(pageSize);

		List<Category> categoryList = categoryService.findAll();

		modelMap.put("postList", postList);

		modelMap.put("categoryList", categoryList);

		return new ModelAndView("/index", modelMap);
	}

}
