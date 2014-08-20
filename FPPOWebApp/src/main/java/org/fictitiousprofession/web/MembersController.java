package org.fictitiousprofession.web;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.fictitiousprofession.entities.Address;
import org.fictitiousprofession.entities.PhoneNumber;
import org.fictitiousprofession.entities.PhoneType;
import org.fictitiousprofession.entities.User;
import org.fictitiousprofession.web.form.EditAddressInfoForm;
import org.fictitiousprofession.web.form.EditBasicInfoForm;
import org.fictitiousprofession.web.form.EditPhoneInfoForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application member pages.
 */
@Controller
@RequestMapping("/members")
public class MembersController extends AbstractBaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(MembersController.class);
	@Autowired private ApplicationContext context;

	@RequestMapping(method = RequestMethod.GET)
	@Secured(value = "ROLE_USER")
	public String members(Model model, HttpSession session, Principal principal) {
		logger.info("MembersController.members()");
		
		User user = userService.findUserByUsername(principal.getName());
		session.setAttribute("user", user);
		model.addAttribute("user", user);
		
		return "members/members";
	}
	
	// GET basic info change form
	@RequestMapping(value = "editBasicInfo", method = RequestMethod.GET)
	@Secured(value = "ROLE_USER")
	public EditBasicInfoForm editBasicInfoGet(HttpSession session) {
		logger.info("MembersController.editBasicInfoGet()");
		
		User user = (User) session.getAttribute("user");
		
		EditBasicInfoForm form = new EditBasicInfoForm();
		form.setUsername(user.getUsername());
		form.setFirstname(user.getFirstname());
		form.setLastname(user.getLastname());
		form.setEmail(user.getEmail());
		
		return form;
	}
	
	// POST changed basic info form
	@RequestMapping(value = "editBasicInfo", method = RequestMethod.POST)
	@Secured(value = "ROLE_USER")
	public String editBasicInfoPost(Model model, HttpSession session,
			@Valid @ModelAttribute("editBasicInfoForm") EditBasicInfoForm form, BindingResult result) {
		
		logger.info("MembersController.editBasicInfoPost()");
		
		if (result.hasErrors()) {
			return "members/editBasicInfo";
		}
		
		User user = (User) session.getAttribute("user");
		
		user.setFirstname(form.getFirstname());
		user.setLastname(form.getLastname());
		user.setEmail(form.getEmail());
		user.setUsername(form.getUsername());
		
		userService.save(user);
		model.addAttribute("user", user);
		
		return "redirect:";
	}
	
	// GET address info change form
	@RequestMapping(value = "editAddressInfo", method = RequestMethod.GET)
	@Secured(value = "ROLE_USER")
	public EditAddressInfoForm editAddressInfoGet(HttpSession session) {
		logger.info("MembersController.editAddressInfoGet()");
		
		User user = (User) session.getAttribute("user");

		Address addr = user.getAddresses().get(0);
		
		EditAddressInfoForm form = new EditAddressInfoForm();
		form.setAddressLine1(addr.getLine1());
		form.setAddressLine2(addr.getLine2());
		form.setCity(addr.getCity());
		form.setPostalCode(addr.getPostalCode());
		form.setAddressType(addr.getType());
		form.setState(addr.getState());
		
		return form;
	}
	
	// POST changed form
	@RequestMapping(value = "editAddressInfo", method = RequestMethod.POST)
	@Secured(value = "ROLE_USER")
	public String editAddressInfoPost(Model model, HttpSession session,
			@Valid @ModelAttribute("editAddressInfoForm") EditAddressInfoForm form, BindingResult result) {
		
		logger.info("MembersController.editAddressInfoPost()");
		
		if (result.hasErrors()) {
			return "members/editAddressInfo";
		}
		
		User user = (User) session.getAttribute("user");
		Address addr = user.getAddresses().get(0);
		addr.setLine1(form.getAddressLine1());
		addr.setLine2(form.getAddressLine2());
		addr.setCity(form.getCity());
		addr.setState(form.getState());
		addr.setPostalCode(form.getPostalCode());
		
		userService.save(user);
		model.addAttribute("user", user);
		return "members/members";
	}
	
	// GET address info change form
	@RequestMapping(value = "editPhoneInfo", method = RequestMethod.GET)
	@Secured(value = "ROLE_USER")
	public EditPhoneInfoForm editPhoneInfoGet(HttpSession session) {
		logger.info("MembersController.editPhoneInfoGet()");
		
		User user = (User) session.getAttribute("user");

		PhoneNumber phone = user.getPhoneNumbers().get(0);
		EditPhoneInfoForm form = new EditPhoneInfoForm();
		form.setPhoneNumber(phone.getNumber());
		form.setType(PhoneType.HOME);
		form.setExtension(phone.getExtension());
		
		return form;
	}
	
	// POST changed form
	@RequestMapping(value = "editPhoneInfo", method = RequestMethod.POST)
	@Secured(value = "ROLE_USER")
	public String editPhoneInfoPost(Model model, HttpSession session,
			@Valid @ModelAttribute("editPhoneInfoForm") EditPhoneInfoForm form, BindingResult result) {
		
		logger.info("MembersController.editPhoneInfoPost()");
		
		if (result.hasErrors()) {
			return "members/editPhoneInfo";
		}
		
		User user = (User) session.getAttribute("user");
		PhoneNumber phone = user.getPhoneNumbers().get(0);
		phone.setExtension(form.getExtension());
		phone.setNumber(form.getPhoneNumber());
				
		userService.save(user);
		
		model.addAttribute("user", user);
		return "members/members";
		
	}
	
}
