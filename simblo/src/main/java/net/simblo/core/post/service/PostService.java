package net.simblo.core.post.service;

import java.util.List;

import net.simblo.base.service.IService;
import net.simblo.core.post.vo.Post;

public interface PostService extends IService<Post> {

	List<Post> listTopPosts(int currpage, int pageSize);

	List<Post> listAll();

}
