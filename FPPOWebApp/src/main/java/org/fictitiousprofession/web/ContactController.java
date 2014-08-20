package org.fictitiousprofession.web;

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
@RequestMapping("/contact")
public class ContactController {
	
	private static final Logger logger = LoggerFactory.getLogger(ContactController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String contact(Model model) {
		logger.info("ContactController.contact()");
		
		return "contact";
	}
	
}
