package org.fictitiousprofession.web;

import java.util.List;

import javax.validation.Valid;

import org.fictitiousprofession.entities.User;
import org.fictitiousprofession.service.MailService;
import org.fictitiousprofession.web.form.CreateMailingForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/mail")
public class MailController extends AbstractBaseController {

	@Autowired private MailService mailService;
	
	@RequestMapping(value = "createMailing", method = RequestMethod.GET)
	@Secured("ROLE_ADMIN")
	public CreateMailingForm createEmailGet() {

		CreateMailingForm form = new CreateMailingForm();

		return form;

	}

	@RequestMapping(value = "createMailing", method = RequestMethod.POST)
	@Secured("ROLE_ADMIN")
	public String createMailPost(Model model,
			@Valid @ModelAttribute CreateMailingForm form, BindingResult result) {
		
		if (result.hasErrors()) {
			return "mail/createMailing";
		}
		
		List<User> users = mailService.sendMail(form.getSubject(), form.getMessage(), form.isPaid(), form.isNonPaid());
		
		model.addAttribute("users", users);
		return "mail/confirmMailing";
		
	}
	
	
}
