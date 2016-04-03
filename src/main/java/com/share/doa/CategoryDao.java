package com.share.doa;

import com.share.domain.Category;

import java.util.Set;

/**
 * Created by mix on 20.03.2016.
 */
public interface CategoryDao {
    public Category add(Category category);
    public Category findById(int categoryId);
    public void update(Category category);
    public Set<Category> getAll();
}
