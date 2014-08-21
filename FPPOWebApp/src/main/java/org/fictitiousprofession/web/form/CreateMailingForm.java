package org.fictitiousprofession.web.form;

import java.io.Serializable;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class CreateMailingForm implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Length(min = 1, max = 100, message = "Subject must be between 1 and 100 characters")
	private String subject;
	
	@Length(min = 1, max = 10000, message = "Message must be between 1 and 10000 characters")
	private String message;
	
	private boolean paid;
	private boolean nonPaid;
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isPaid() {
		return paid;
	}
	public void setPaid(boolean paid) {
		this.paid = paid;
	}
	public boolean isNonPaid() {
		return nonPaid;
	}
	public void setNonPaid(boolean nonPaid) {
		this.nonPaid = nonPaid;
	}
	
	@AssertTrue(message="You must select an audience")
	private boolean isValid() {
	    return (isNonPaid() || isPaid());
	}
	
}
