package com.aiw.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "articles")
public class Article implements Serializable {
	protected final static long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String summary;
	private String content;
	private Timestamp date;

	@ManyToOne
	@JoinColumn(name = "id_category", referencedColumnName = "id")
	private Category category;
	@ManyToOne
	@JoinColumn(name = "id_author", referencedColumnName = "id")
	private Author author;
	@ManyToMany(targetEntity = Tag.class, fetch = FetchType.EAGER)
	@JoinTable(name = "article_tags", joinColumns = {
			@JoinColumn(name = "article_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "tag_id", referencedColumnName = "id") })
	private Set<Tag> tags;

	public Article() {

	}

	public Article(String name, String summary, String content, Timestamp date, Category category, Author author,
			Set<Tag> tags) {
		this.name = name;
		this.summary = summary;
		this.content = content;
		this.date = date;
		this.category = category;
		this.author = author;
		this.tags = tags;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

}
