package net.simblo.core.index.controller;

import net.simblo.base.controller.BaseAction;
import net.simblo.base.vo.ValueObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController extends BaseAction {

	public IndexController() {
		super(new ValueObject());
	}

	private Logger logger = LoggerFactory.getLogger(IndexController.class);

	@RequestMapping("/index")
	public String doIndex() throws Exception {
		logger.warn("IndexController Involved");
		return "index";
	}

}
