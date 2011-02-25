package net.simblo.base.controller;

import java.util.Collection;
import java.util.Map;

import net.simblo.base.vo.ValueObject;

/**
 * @author Sam
 * 
 */
public abstract class BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1268857716512544533L;

	private ValueObject vo;

	public BaseController(ValueObject vo) {
		this.vo = vo;
	}

	private Collection<? extends ValueObject> dataList;

	private Map<String, ? extends ValueObject> dataMap;

	public void setDataList(Collection<? extends ValueObject> dataList) {
		this.dataList = dataList;
	}

	public Collection<? extends ValueObject> getDataList() {
		return dataList;
	}

	public void setVo(ValueObject vo) {
		this.vo = vo;
	}

	public ValueObject getVo() {
		return vo;
	}

	public void setDataMap(Map<String, ? extends ValueObject> dataMap) {
		this.dataMap = dataMap;
	}

	public Map<String, ? extends ValueObject> getDataMap() {
		return dataMap;
	}

}
