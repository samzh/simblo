package net.simblo.core.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
	
	@RequestMapping(value="/admin")
	public ModelAndView doAdmin() {
		return new ModelAndView("/admin/panel");
	}

}
