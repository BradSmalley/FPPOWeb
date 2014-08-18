package org.fictitiousprofession.web.form;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

import org.fictitiousprofession.entities.AddressType;
import org.hibernate.validator.constraints.Length;

public class EditAddressInfoForm implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private AddressType addressType = AddressType.SHIPPING;
	
	@Length(min = 1, max = 200, message = "Address Line 1 must be between 1 and 200 characters.")
	private String addressLine1;
	
	@Length(max = 200, message = "Address Line 2 must not exceed 200 characters.")
	private String addressLine2;
	
	@Length(min = 1, max = 45, message = "City must be between 1 and 45 characters.")
	private String city;
	
	@Length(min = 2, max = 200, message = "State must be between 2 and 45 characters.")
	private String state;
	
	@Pattern(regexp = "^\\d{5}$|^\\d{5}-\\d{4}$|^\\d{9}$", message = "Postal code must be valid (e.g. 12345-3434)")
	private String postalCode;
	
	public AddressType getAddressType() {
		return addressType;
	}
	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
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
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	
	

}
