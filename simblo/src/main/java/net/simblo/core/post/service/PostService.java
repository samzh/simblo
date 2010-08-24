package net.simblo.core.post.service;

import java.util.List;

import net.simblo.core.post.vo.Post;

public interface PostService {

	List<Post> listTopPosts(int count);

}
