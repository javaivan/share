package com.share.controller;

import com.share.domain.Category;
import com.share.domain.Post;
import com.share.service.CategoryService;
import com.share.service.PostService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/**
 * Created by mix on 20.03.2016.
 */
@Controller
@RequestMapping(value = {"/category/"})
public class CategoryController {

    private static final Logger logger = Logger.getLogger(CategoryController.class);

    private CategoryService categoryService;

    public void setCategoryService(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @RequestMapping( method = RequestMethod.GET)
    public String allCategory(ModelMap model) {
        logger.debug("CategoryController: allCategory");

        Set<Category> listCategories = categoryService.getAll();
        model.addAttribute("listCategories", listCategories);
        return "category/all";
    }


    @RequestMapping(value = {"add"}, method = RequestMethod.GET)
    public String addPostPage(ModelMap model) {
        logger.debug("CategoryController: addPostPage");

        Category category =  new Category();
        model.addAttribute("category", category);
        return "category/add";
    }

    @RequestMapping(value = {"add"}, method = RequestMethod.POST)
    public String addCategory(@ModelAttribute("category") Category category, BindingResult result){
        logger.debug("CategoryController: addCategory: " + category);

        categoryService.add(category);
        return "redirect:/category/";
    }


    @RequestMapping(value = {"{catid}"}, method = RequestMethod.GET)
    public String getCategory(@PathVariable int catid, ModelMap model){
        logger.debug("CategoryController: getCategory: " + catid);

        Category category = categoryService.findById(catid);
        if(category == null){
            logger.warn("CategoryController: getCategory:" + catid);

            return "redirect:/category/";
        }

        model.addAttribute("category", category);
        return "category/category";
    }


    @RequestMapping(value = {"update/{catid}"}, method = RequestMethod.GET)
    public String updateCategory(@PathVariable int catid, ModelMap model){
        logger.debug("CategoryController: getCategory: " + catid);

        Category category = categoryService.findById(catid);
        if(category == null){
            logger.warn("CategoryController: getCategory:" + catid);

            return "redirect:/category/";
        }

        model.addAttribute("category", category);
        return "category/update";
    }

    @RequestMapping(value = {"update"}, method = RequestMethod.POST)
    public String updateCategory(@ModelAttribute("category") Category c, BindingResult result){
        logger.debug("CategoryController: updateCategory: ");

        Category category = this.categoryService.findById(c.getId());
        category.setTitle(c.getTitle().trim());

        this.categoryService.update(category);

        return "redirect:/category/";

    }

/*
    @RequestMapping(value="/category/update", method=RequestMethod.POST)
    public @ResponseBody Map<String, ? extends Object> updateCategory(@RequestBody Category c, HttpServletResponse response) {
        logger.debug("CategoryController: updateCategory: ");

        Category category = this.categoryService.findById(c.getId());
        category.setTitle(c.getTitle().trim());

        this.categoryService.update(category);

        return Collections.singletonMap("category", c);
        //return "redirect:/category-all";
    }*/

}
