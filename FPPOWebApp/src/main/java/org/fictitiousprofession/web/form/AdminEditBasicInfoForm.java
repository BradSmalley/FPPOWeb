package org.fictitiousprofession.web.form;

import java.util.Date;

import javax.validation.constraints.Pattern;

public class AdminEditBasicInfoForm extends EditBasicInfoForm {

	private static final long serialVersionUID = 1L;
	
	public Date registrationDate;
	public boolean paid;
	
	@Pattern(regexp = "^$|^\\d{2}/\\d{2}/\\d{4}$", message = "Last payment date must be mm/dd/yyyy")
	public String lastPaymentDate;
	
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	public boolean isPaid() {
		return paid;
	}
	public void setPaid(boolean paid) {
		this.paid = paid;
	}
	public String getLastPaymentDate() {
		return lastPaymentDate;
	}
	public void setLastPaymentDate(String lastPaymentDate) {
		this.lastPaymentDate = lastPaymentDate;
	}

}
