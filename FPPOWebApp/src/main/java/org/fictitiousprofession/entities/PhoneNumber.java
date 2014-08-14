package org.fictitiousprofession.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "phone")
public class PhoneNumber implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	@Column(name = "user_id", nullable = false)
	private Integer userId;
	private Integer type;
	private String number;
	private String extension;
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name = "user_id")
	private User user;
	
	protected PhoneNumber() {
		
	}
	
	public PhoneNumber(String number) {
		this.number = number;
		this.type = 1;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
