package com.cts.newsbuddy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "article")
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "art_id")
	private int id;

	@Column(name = "art_title")
	private String title;

	@Column(name = "art_desc")
	private String description;

	@Column(name = "art_author")
	private String author;

	@Column(name = "art_url")
	private String url;

	@Column(name = "art_img_url")
	private String urlToImage;

	@Column(name = "art_src")
	private String source;

	@Transient
	private int userId;

	public int getId() {
		return id;
	}

	public String getUrlToImage() {
		return urlToImage;
	}

	public void setUrlToImage(String urlToImage) {
		this.urlToImage = urlToImage;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getImgUrl() {
		return urlToImage;
	}

	public void setImgUrl(String imgUrl) {
		this.urlToImage = imgUrl;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", description=" + description + ", author=" + author
				+ ", url=" + url + ", urlToImage=" + urlToImage + ", source=" + source + ", userId=" + userId + "]";
	}
}

