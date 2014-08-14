package org.fictitiousprofession.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.fictitiousprofession.entities.Address;
import org.fictitiousprofession.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
	
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("FPPOWebApp");
		EntityManager em = factory.createEntityManager();
		
		User user = em.find(User.class, 1);

		Address address = user.getAddesses().get(0);
		model.addAttribute("user", user);
		model.addAttribute("address", address);
		
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		

		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
