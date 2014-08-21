package org.fictitiousprofession.web;

import javax.validation.Valid;

import org.fictitiousprofession.service.MailService;
import org.fictitiousprofession.web.form.CreateMailingForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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
		
//		if (!(form.isNonPaid() || form.isPaid())) {
//			ObjectError error = new ObjectError("paid","You must select an audience, either paid, non-paid, or both");
//			result.addError(error);
//		}
		
		if (result.hasErrors()) {
			return "mail/createMailing";
		}
		
		System.out.println(form.getSubject());
		System.out.println(form.getMessage());
		System.out.println(form.isNonPaid() + " : " + form.isPaid());
		
		mailService.sendMail(form.getSubject(), form.getMessage(), form.isPaid(), form.isNonPaid());
		
		model.addAttribute("success", Boolean.TRUE);
		return "mail/createMailing";
		
	}
	
	
}
