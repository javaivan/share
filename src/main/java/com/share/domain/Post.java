package com.share.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "post")
public class Post {


	@Id
	@Column(name = "id")
	@GeneratedValue
	private Integer id;

	@Column(name = "title")
	private String title;

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

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "post_category",
			joinColumns = { @JoinColumn(name = "post_id")},
			inverseJoinColumns = {@JoinColumn(name = "category_id") })
	private Set<Category> categories = new HashSet<Category>();

	public Set<Category> getCategories() {  return categories;}
	public void setCategories(Set<Category> categories) {   this.categories = categories;}

	@Override
	public String toString() {
		String textString = "Post [id=" + id + ", title=" + title + ", categories = ";

		for (Category category: this.categories){
			textString += " ' " + category + " ' ";
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
