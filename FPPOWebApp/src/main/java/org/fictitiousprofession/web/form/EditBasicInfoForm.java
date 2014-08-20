package org.fictitiousprofession.web.form;

import java.io.Serializable;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

public class EditBasicInfoForm implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Length(min = 1, max = 45, message="Username must be between 1 and 45 characters.")
	private String username			= "";
	
	@Length(min = 1, max = 45, message="First Name must be between 1 and 45 characters.")
	private String firstname		= "";
	
	@Length(min = 1, max = 45, message="Last Name must be between 1 and 45 characters.")
	private String lastname			= "";
	
	@Length(min = 1, max = 45, message="Email must be between 6 and 45 characters.")
	@Email
	private String email			= "";
	
	public EditBasicInfoForm() {
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
