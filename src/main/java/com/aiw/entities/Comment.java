package com.aiw.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment implements Serializable {
	protected final static long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String commentor;
	private String message;
	private Timestamp date;
	private long idarticle;

	public Comment() {
	}

	public Comment(String commentor, String message, long idarticle) {
		this.commentor = commentor;
		this.message = message;
		this.idarticle = idarticle;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCommentor() {
		return commentor;
	}

	public void setCommentor(String commentor) {
		this.commentor = commentor;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public long getIdarticle() {
		return idarticle;
	}

	public void setIdarticle(long idarticle) {
		this.idarticle = idarticle;
	}
}
