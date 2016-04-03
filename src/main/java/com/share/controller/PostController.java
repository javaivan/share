package com.share.controller;



import org.apache.log4j.Logger;

import com.share.domain.Category;
import com.share.domain.Post;
import com.share.service.CategoryService;
import com.share.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Set;

/**
 * Created by mix on 20.03.2016.
 */
@Controller
@SessionAttributes("cat")
@RequestMapping(value = {"/post/"})
public class PostController {
    private static final Logger logger = Logger.getLogger(PostController.class);


    private PostService postService;
    private CategoryService categoryService;

    public void setPostService(PostService postService){
        this.postService = postService;
    }
    public void setCategoryService(CategoryService categoryService){this.categoryService = categoryService;}


    @RequestMapping(method = RequestMethod.GET)
    public String allPost(ModelMap model) {
        logger.debug("PostController: allPost");

        Set<Post> listPosts = postService.getAll();
        model.addAttribute("postList", listPosts);
        return "post/all";
    }

    @RequestMapping(value = {"add"}, method = RequestMethod.GET)
    public String addPostPage(ModelMap model) {
        logger.debug("PostController: addPostPage");

        Post post = new Post();
        model.addAttribute("post", post);
        return "post/add";
    }


    @RequestMapping(value = {"/add"}, method = RequestMethod.POST)
    public String addPost(@ModelAttribute("post") Post post, BindingResult result){
        logger.debug("PostController: addPost: " + post);

        postService.add(post);
        return "redirect:/post/";
    }

    @ModelAttribute("cat")
    public Set<Category> getCategories() {
        logger.debug("PostController: getCategories");

        return categoryService.getAll();
    }

}
