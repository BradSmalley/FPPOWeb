package org.fictitiousprofession.web.form;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.fictitiousprofession.entities.PhoneType;

public class EditPhoneInfoForm implements Serializable {

	private final static long serialVersionUID = 1L;
	
	private PhoneType type = PhoneType.HOME;
	
	@NotNull
	@Pattern(regexp = "\\d{10}", message = "Phone Number must be exactly 10 digits.")
	private String phoneNumber;
	
	@Pattern(regexp = "\\d{0,10}", message = "Extension must be between 0 and 10 digits.")
	private String extension;
	
	public PhoneType getType() {
		return type;
	}
	public void setType(PhoneType type) {
		this.type = type;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	
}
