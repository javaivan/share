package com.share.domain;

import javax.persistence.*;

@Entity
@Table(name = "caterory")
public class Category {


	@Id
	@Column(name = "id")
	@GeneratedValue
	private Integer id;

	@Column(name = "title")
	private String title;

	public Category() {
	}

	public Category(String title) {
		this.title = title;
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
