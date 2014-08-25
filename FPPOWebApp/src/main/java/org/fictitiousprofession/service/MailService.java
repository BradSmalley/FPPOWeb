package org.fictitiousprofession.service;

import java.util.List;

import org.fictitiousprofession.entities.User;

public interface MailService {

	List<User> sendMail(String subject, String message, boolean paid, boolean nonPaid);
	
}
