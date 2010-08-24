package net.simblo.base.action;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;

import net.simblo.util.StringUtil;

public class ParamsTable implements Serializable {

	private static final long serialVersionUID = 8612650687748066306L;
	
	private HashMap params = new HashMap();
	
	public void setParameter(String name, Object value) {
		if (value instanceof String) {
			params.put(name, StringUtil.dencodeHTML((String) value));
		} else {
			params.put(name, value);
		}
	}
	
	public Object getParameter(String name) {
		return params.get(name);
	}
	
	public boolean isEmpty() {
		return params.isEmpty();
	}
	
	public Set keySet() {
		return params.keySet();
	}

}
