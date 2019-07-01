package com.cts.newsbuddy.entity;
 
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "user_registration")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int id;

	@NotNull(message = "Name cannot be empty!")
	@Column(name = "user_name")
	@Size(max = 70, message = "Name cannot exceed 70 characters!")
	private String name;

	@NotNull(message = "Password cannot be empty!")
	@Size(min = 6, max = 100, message = "Password must be 6 to 30 characters!")
	@Column(name = "user_password")
	private String password;
	
	@NotNull(message = "Email cannot be empty!")
	@Size(max = 255, message = "Email cannot exceed 255 characters!")
	@Pattern(regexp = ".+@.+\\..+", message = "Invalid email address!")
	@Column(name = "user_email")
	private String email;

	

	
	@Column(name = "user_role")
	private String role;

	
	@Column(name = "user_language_id")
	private String language;

	@Column(name = "user_blacklist")
	private boolean blacklist;

//	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinTable(name = "user_article", joinColumns = { @JoinColumn(name = "ua_us_id") }, inverseJoinColumns = {
//			@JoinColumn(name = "ua_art_id") })
//	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
//	private List<Article> articles;
//
//	public List<Article> getArticles() {
//		return articles;
//	}
//
//	public void setArticles(List<Article> articles) {
//		this.articles = articles;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public boolean isBlacklist() {
		return blacklist;
	}

	public void setBlacklist(boolean blacklist) {
		this.blacklist = blacklist;
	}

	public User() {
		super();
	}

	public User(
			@NotNull(message = "Name cannot be empty!") @Size(max = 70, message = "Name cannot exceed 70 characters!") String name,
			@NotNull(message = "Email cannot be empty!") @Size(max = 255, message = "Email cannot exceed 255 characters!") @Pattern(regexp = ".+@.+\\..+", message = "Invalid email address!") String email,
			@NotNull(message = "Password cannot be empty!") @Size(min = 6, max = 100, message = "Password must be 6 to 30 characters!") String password,
			String role, String language, boolean blacklist) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		
		this.role = role;
		this.language = language;
		this.blacklist = blacklist;
	}

	public User(
			@NotNull(message = "Email cannot be empty!") @Size(max = 255, message = "Email cannot exceed 255 characters!") @Pattern(regexp = ".+@.+\\..+", message = "Invalid email address!") String email,
			@NotNull(message = "Password cannot be empty!") @Size(min = 6, max = 100, message = "Password must be 6 to 30 characters!") String password) {
		super();
		this.email = email;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", role=" + role
				+ ", language=" + language + ", blacklist=" + blacklist +  "]";
	}

}
