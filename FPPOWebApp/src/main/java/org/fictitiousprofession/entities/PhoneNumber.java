package org.fictitiousprofession.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "PHONE")
public class PhoneNumber implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "user_id", nullable = false)
	private Integer userId;
	private PhoneType type;
	private String number;
	private String extension;
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name = "user_id")
	private User user;
	
	protected PhoneNumber() {
		
	}
	
	public PhoneNumber(String number) {
		this.number = number;
		this.type = PhoneType.HOME;
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
	public PhoneType getType() {
		return type;
	}

	public void setType(PhoneType type) {
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
	
	public String toString() {
		return getFormattedNumberWithExtension();
	}
	
	// Convenience Methods
	public String getFormattedNumberWithExtension() {
		String  format = "(%3s) %3s-%4s";
		if (number != null && number.length() == 10) {
			if (getExtension() != null && getExtension().length() > 0) {
				format = format + " x%10s";
			}
			return String.format(format, number.substring(0,3), number.substring(3,  6), number.substring(6, 10), (getExtension() == null ? "" : getExtension()));
		} 
		return "";
	}
	
	public String getFormattedNumber() {
		String  format = "(%3s) %3s-%4s";
		return String.format(format, number.substring(0,3), number.substring(3,  6), number.substring(6, 10));
	}
	
}
