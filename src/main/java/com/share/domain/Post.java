package com.share.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class Post {

	private Integer id;
	private String title;
	private Set<Category> categories = new HashSet<Category>(0);

	public Post() {
	}

	public Post(String title) {
		this.title = title;
	}

	public Post(String title, Set<Category> categories) {
		this.title = title;
		this.categories = categories;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<Category> getCategories() {  return categories;}

	public void setCategories(Set<Category> categories) {   this.categories = categories;}

	@Override
	public String toString() {
		String textString = "Post [id=" + id + ", title=" + title + ", categories = ";
	if(this.categories!=null) {
		for (Category category : this.categories) {
			textString += " ' " + category + " ' ";
		}
	}
		textString += "]";

		return textString;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Post post = (Post) o;

		if (!id.equals(post.id)) return false;
		if (!title.equals(post.title)) return false;
		return categories.equals(post.categories);

	}

	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + title.hashCode();
		result = 31 * result + categories.hashCode();
		return result;
	}
}
