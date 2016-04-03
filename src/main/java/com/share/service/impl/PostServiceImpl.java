package com.share.service.impl;

import com.share.doa.PostDao;
import com.share.doa.impl.PostDaoImpl;
import com.share.domain.Post;
import com.share.service.PostService;
import org.apache.log4j.Logger;

import java.util.Set;

/**
 * Created by mix on 20.03.2016.
 */
public class PostServiceImpl implements PostService{

    private static final Logger logger = Logger.getLogger(CategoryServiceImpl.class);

    private PostDao postDao;

    public void setPostDao(PostDao postDao){
        this.postDao = postDao;
    }

    public PostServiceImpl(){
        postDao = new PostDaoImpl();
    }


    public Post add(Post post) {
        logger.debug("PostServiceImpl: add: " + post);

        return postDao.add(post);
    }

    public void update(Post post) {
        logger.debug("PostServiceImpl: update: " + post);

        postDao.update(post);
    }


    public Set<Post> getAll() {
        logger.debug("PostServiceImpl: getAll");

        return postDao.getAll();
    }
}
