package net.simblo.core.user.service;

import net.simblo.core.user.vo.User;

public interface UserService {
	
	void save(User user);
	
	void delete(User user);
	
	User find(String id);
	
	User findByName(String name);

}
