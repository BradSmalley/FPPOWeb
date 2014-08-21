package org.fictitiousprofession.service;

public interface MailService {

	void sendMail(String subject, String message, boolean paid, boolean nonPaid);
	
}
