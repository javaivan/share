package com.share.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class Category {

	private Integer id;
	private String title;
	private Set<Post> posts = new HashSet<Post>(0);

	public Category() {
	}

	public Category(String title) {
		this.title = title;
	}

	private Category(String title, Set<Post> posts){
		this.title = title;
		this.posts = posts;
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

	public Set<Post> getPosts(){
		return  this.posts;
	}

	public void setPosts(Set<Post> posts){
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "Caterory [id=" + id + ", title=" + title + " ]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Category category = (Category) o;

		if (!id.equals(category.id)) return false;
		return title.equals(category.title);

	}

	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + title.hashCode();
		return result;
	}
}
