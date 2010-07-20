package net.simblo.base.action;

import java.util.Collection;

import net.simblo.base.vo.ValueObject;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Sam
 * 
 */
public abstract class BaseAction extends ActionSupport implements Action {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1268857716512544533L;

	private Collection dataList;

	private ValueObject vo;

	public void setDataList(Collection dataList) {
		this.dataList = dataList;
	}

	public Collection getDataList() {
		return dataList;
	}

	public void setVo(ValueObject vo) {
		this.vo = vo;
	}

	public ValueObject getVo() {
		return vo;
	}

}
