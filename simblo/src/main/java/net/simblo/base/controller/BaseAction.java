package net.simblo.base.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import net.simblo.base.vo.ValueObject;

/**
 * @author Sam
 * 
 */
public abstract class BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1268857716512544533L;

	private ValueObject vo;

	public BaseAction(ValueObject vo) {
		this.vo = vo;
	}

	@SuppressWarnings("rawtypes")
	private Collection dataList;

	@SuppressWarnings("rawtypes")
	private Map dataMap = new HashMap();

	@SuppressWarnings("rawtypes")
	public void setDataList(Collection dataList) {
		this.dataList = dataList;
	}

	@SuppressWarnings("rawtypes")
	public Collection getDataList() {
		return dataList;
	}

	public void setVo(ValueObject vo) {
		this.vo = vo;
	}

	public ValueObject getVo() {
		return vo;
	}

	@SuppressWarnings("rawtypes")
	public void setDataMap(Map dataMap) {
		this.dataMap = dataMap;
	}

	@SuppressWarnings("rawtypes")
	public Map getDataMap() {
		return dataMap;
	}

}