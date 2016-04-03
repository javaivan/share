package com.share.service;

import com.share.domain.Post;

import java.util.Set;

/**
 * Created by mix on 20.03.2016.
 */
public interface PostService {
    public Post add(Post post);
    public void update(Post post);
    public Set<Post> getAll();
}
