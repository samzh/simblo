package net.simblo.core.user.service;

import net.simblo.base.service.IService;

public interface UserService<User> extends IService<User> {
	
	User findByName(String name);

}
