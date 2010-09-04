package net.simblo.base.vo;

import java.util.Date;

public interface IValueObject {
	
	long getId();
	
	void setId(long id);
	
	Date getCreated();
	
	void setCreated(Date created);
	
	Date getUpdated();
	
	void setUpdated(Date updated);

}
