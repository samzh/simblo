package net.simblo.core.user.vo;

import net.simblo.base.vo.ValueObject;

public class User extends ValueObject {
	
	private String userName;
	
	private String password;

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}
	
}
