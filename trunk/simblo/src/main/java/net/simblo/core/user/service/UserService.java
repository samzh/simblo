package net.simblo.core.user.service;

import net.simblo.base.service.IService;
import net.simblo.core.user.vo.User;

public interface UserService extends IService<User> {
	
	User findByName(String name);

}
