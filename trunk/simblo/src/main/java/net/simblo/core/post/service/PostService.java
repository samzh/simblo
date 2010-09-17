package net.simblo.core.post.service;

import java.util.List;

import net.simblo.base.service.IService;

public interface PostService<T> extends IService<T> {

	List<T> listTopPosts(int currpage, int pageSize);

	List<T> listAll();

}
