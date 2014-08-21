package org.fictitiousprofession.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service("mailService")
public class MailServiceImpl implements MailService {

	@Autowired private MailSender sender;
	
	@Override
	public void sendMail(String subject, String message, boolean paid,boolean nonPaid) {
		// TODO: Implement
		
		SimpleMailMessage simpleMessage = new SimpleMailMessage();
		simpleMessage.setTo("brad.smalley@illinois.gov");
		simpleMessage.setFrom("brad.smalley@gmail.com");
		simpleMessage.setSubject(subject);
		simpleMessage.setText(message);
		
		sender.send(simpleMessage);
		
	}

}
