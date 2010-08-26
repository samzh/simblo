package net.simblo.core.index.action;

import net.simblo.base.action.BaseAction;
import net.simblo.base.vo.ValueObject;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("serial")
public class IndexAction extends BaseAction {

	public IndexAction(ValueObject vo) {
		super(vo);
	}

	private Logger logger = LoggerFactory.getLogger(IndexAction.class);

	// @SuppressWarnings("unchecked")

	@Action(results = { @Result(name = "success", location = "/input.jsp") })
	public String doIndex() throws Exception {
		logger.warn("IndexAction Involved");
		return SUCCESS;
	}

}
