package com.share.service.impl;

import com.share.doa.CategoryDao;
import com.share.doa.PostDao;
import com.share.doa.impl.CategotyDaoImpl;
import com.share.doa.impl.PostDaoImpl;
import com.share.domain.Category;
import com.share.domain.Post;
import com.share.service.CategoryService;
import com.share.service.PostService;
import org.apache.log4j.Logger;

import java.util.Set;

/**
 * Created by mix on 20.03.2016.
 */
public class CategoryServiceImpl implements CategoryService {

    private static final Logger logger = Logger.getLogger(CategoryServiceImpl.class);

    private CategoryDao categoryDao;

    public void setCategoryDao(CategoryDao categoryDao){
        this.categoryDao = categoryDao;
    }

    public Category add(Category category) {
        logger.debug("CategoryServiceImpl: add:" + category);

        return categoryDao.add(category);
    }

    public Category findById(int categoryId) {
        logger.debug("CategoryServiceImpl: findById: " + categoryId);

        return categoryDao.findById(categoryId);
    }

    public void update(Category category) {
        logger.debug("CategoryServiceImpl: update: " + category);

        categoryDao.update(category);
    }


    public Set<Category> getAll() {
        logger.debug("CategoryServiceImpl: getAll");

        return categoryDao.getAll();
    }

}
