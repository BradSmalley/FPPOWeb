package org.fictitiousprofession.web.form;

import java.io.Serializable;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

public class RegistrationForm implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotNull
	@Length(min = 1, max = 45, message = "Username must be between 1 and 45 characters long.")
	private String username					= "";
	
	@Length(min = 6, max = 45, message = "Password must be between 6 and 45 characters long.")
	private String password					= "";
	
	@Length(min = 6, max = 45, message = "Retype Password must be between 6 and 45 characters long.")
	private String retypePassword			= "";
	
	@Length(min = 1, max = 45, message = "Last Name must be between 1 and 45 characters long.")
	private String lastname					= "";
	
	@Length(min = 1, max = 45, message = "First Name must be between 1 and 45 characters long.")
	private String firstname				= "";
	
	@Email(message = "Email must be a valid email address.")
	private String email					= "";
	
	@Length(min = 10, max = 200, message = "Address Line 1 must be between 10 and 200 characters long.")
	private String addressLine1				= "";
	private String addressLine2				= "";
	
	@Length(min = 2, max = 45, message = "City must be between 2 and 45 characters long.")
	private String city						= "";
	
	@Length(min = 2, max = 45, message = "State must be between 1 and 45 characters long.")
	private String state					= "";
	
	@Length(min = 5, max = 10, message = "Postal Code must be between 5 and 10 characters long.")
	@Pattern(regexp = "\\d{5}|\\d{5}-\\d{4}|\\d{9}", message = "Postal Code must be valid (e.g. 12121-1212)")
	private String postalCode				= "";
	
	@Length(min = 10, max = 10, message = "Phone number must be exactly 10 digits")
	@Digits(integer = 10, fraction = 0, message = "Phone number must be exactly 10 digits.")
	private String phoneNumber				= "";
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRetypePassword() {
		return retypePassword;
	}
	public void setRetypePassword(String retypePassword) {
		this.retypePassword = retypePassword;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@AssertTrue(message="Password and Retype Password must match")
	private boolean isValid() {
	    return this.password.equals(this.retypePassword);
	}
	
}
