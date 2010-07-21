package net.simblo.core.user.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import net.simblo.base.vo.ValueObject;

@Entity
@Table(name = "si_user")
public class User extends ValueObject {
	
	private String userName;
	
	private String password;

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "username")
	public String getUserName() {
		return userName;
	}
	
}
