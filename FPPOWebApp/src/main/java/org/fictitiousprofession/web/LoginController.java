package org.fictitiousprofession.web;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.Valid;

import org.fictitiousprofession.entities.Address;
import org.fictitiousprofession.entities.AddressType;
import org.fictitiousprofession.entities.PhoneNumber;
import org.fictitiousprofession.entities.Role;
import org.fictitiousprofession.entities.User;
import org.fictitiousprofession.web.form.RegistrationForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	@Autowired private PasswordEncoder encoder;

	@RequestMapping(value = "/login/", method = RequestMethod.GET)
	public String login(Model model) {
		logger.info("LoginController.login()");
		
		return "login/login";
	}
	
	@RequestMapping(value = "/login/register/", method = RequestMethod.GET) 
	public ModelAndView getRegister() {
		logger.info("LoginController.getRegister()");
		
		RegistrationForm form = new RegistrationForm();
		
		return new ModelAndView("login/register", "command", form);
	}
	
	@RequestMapping(value = "/login/register/", method = RequestMethod.POST)
	public ModelAndView postRegister(@Valid @ModelAttribute RegistrationForm form, BindingResult result) {
		logger.info("LoginController.postRegister()");
		
		if (result.hasErrors()) {
			System.err.println(String.format("Errors Detected: %s", result.getErrorCount()));
			for (ObjectError e : result.getAllErrors()) {
				System.err.println(e.getDefaultMessage());
				
			}
			return new ModelAndView("login/register", "command", form);
		}
		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("FPPOWebApp");
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		User user = new User();
		em.persist(user);
		
		Address address = new Address();
		PhoneNumber phone = new PhoneNumber(form.getPhoneNumber());
		
		Role role = new Role();
		role.setRole("ROLE_USER");
		address.setType(AddressType.SHIPPING); //TODO:  ???
		address.setLine1(form.getAddressLine1());
		address.setLine2(form.getAddressLine2());
		address.setCity(form.getCity());
		address.setState(form.getState());
		address.setPostalCode(form.getPostalCode());
		
		user.setEmail(form.getEmail());
		user.setFirstname(form.getFirstname());
		user.setLastname(form.getLastname());
		user.setPassword(encoder.encode(form.getPassword()));
		user.setRegistrationDate(new Date());
		user.setUsername(form.getUsername());	
		user.setPaid(false); //TODO:  ??
		
		em.flush();
		
		address.setUserId(user.getId());
		phone.setUserId(user.getId());
		role.setUserId(user.getId());
		
		user.getAddresses().add(address);
		user.getPhoneNumbers().add(phone);
		user.getRoles().add(role);
		
		em.getTransaction().commit();
		
		
		return new ModelAndView("login/confirmation", "command", form);
	}
	
	
	
}
