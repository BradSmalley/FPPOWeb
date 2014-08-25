package org.fictitiousprofession.service;

import java.util.ArrayList;
import java.util.List;

import org.fictitiousprofession.entities.User;
import org.fictitiousprofession.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service("mailService")
public class MailServiceImpl implements MailService {

	@Autowired private MailSender sender;
	@Autowired private UserRepository userRepository;
	
	@Override
	public List<User> sendMail(String subject, String message, boolean paid,boolean nonPaid) {

		List<User> users = new ArrayList<User>();
		if (paid && nonPaid) {
			users = userRepository.findAll();
		} else if (paid) {
			users = userRepository.findPaid();
		} else if (nonPaid) {
			users = userRepository.findNonPaid();
		}
		
		MailThread mt = new MailThread(users, subject, message);
		new Thread(mt).start();
		
		return users;
		
	}
	
	class MailThread implements Runnable {

		private final String FROM = "FPPO@fictitiousprofession.org";
		private List<User> recipients = new ArrayList<User>();
		private String subject;
		private String message;
		
		protected MailThread(List<User> recipients, String subject, String message) {
			this.recipients = recipients;
			this.subject = subject;
			this.message = message;
		}
		
		@Override
		public void run() {
			
			for (User recipient : recipients) {
				
				SimpleMailMessage simpleMessage = new SimpleMailMessage();
				simpleMessage.setTo(recipient.getEmail());
				simpleMessage.setFrom(FROM);
				simpleMessage.setSubject(subject);
				simpleMessage.setText(message);
				sender.send(simpleMessage);
			}
			
		}
		
		public void setRecipients(List<User> recipients) {
			this.recipients = recipients;
		}
		
		protected List<User> getRecipients() {
			return this.recipients;
		}

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
	}

}
