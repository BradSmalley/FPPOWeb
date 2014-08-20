package org.fictitiousprofession.web;

import javax.validation.Valid;

import org.fictitiousprofession.entities.User;
import org.fictitiousprofession.web.form.RegistrationForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/register")
public class RegisterController extends AbstractBaseController {

	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
	
	@RequestMapping(method = RequestMethod.GET) 
	public ModelAndView getRegister() {
		logger.info("LoginController.getRegister()");
		return new ModelAndView("register/register", "registrationForm", new RegistrationForm());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String postRegister(Model model, @Valid @ModelAttribute RegistrationForm form, BindingResult result) {
		logger.info("RegisterController.postRegister()");
		
		if (result.hasErrors()) {
			return "register/register";
		}
			
		User user = userService.register(form);
		
		model.addAttribute("user", user);
		return "register/confirmation";
	}
	
	
}
