package com.share.converter;

import com.share.domain.Category;
import com.share.service.CategoryService;
import org.apache.log4j.Logger;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by mix on 21.03.2016.
 */
public class CategoryConverter  implements Converter<Object, Category> {
    private static final Logger logger = Logger.getLogger(CategoryConverter.class);


    private CategoryService categoryService;

    public void setCategoryService(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    public Category convert(Object element) {
        logger.debug("CategoryConverter: convert");

        if(element instanceof Category){
            logger.debug("CategoryConverter: instanceof: " + element);
            return (Category) element;
        }

        Integer id = Integer.parseInt((String)element);
        logger.debug("CategoryConverter: convert Integer: " + id);

        Category category = categoryService.findById(id);
        logger.debug("CategoryConverter: convert Category: " + category);

        return category;
    }
}
