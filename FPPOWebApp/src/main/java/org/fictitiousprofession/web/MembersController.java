package org.fictitiousprofession.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application member pages.
 */
@Controller
public class MembersController extends AbstractBaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(MembersController.class);
	@Autowired private ApplicationContext context;

	@RequestMapping(value = "/members", method = RequestMethod.GET)
	@Secured(value = "ROLE_USER")
	public String members(Model model, HttpServletRequest req, HttpServletResponse resp) {
		logger.info("MembersController.members()");
		
		System.out.println(model.getClass().getCanonicalName());
		
		SecurityContext secContext = (SecurityContext) req.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
		Authentication auth = secContext.getAuthentication();
		
		User user = userService.findUserByUsername(auth.getName());
		req.getSession().setAttribute("user", user);
		model.addAttribute("user", user);
		
		return "members/members";
	}
	
	// GET basic info change form
	@RequestMapping(value = "/members/editBasicInfo/{memberId}/", method = RequestMethod.GET)
	@Secured(value = "ROLE_USER")
	public ModelAndView editBasicInfoGet(@PathVariable("memberId") String memberId, HttpServletRequest req) {
		logger.info("MembersController.editBasicInfoGet()");
		
		User user = userService.findUserById(Integer.valueOf(memberId));
		System.out.println(user.getId());
		
		req.getSession().setAttribute("user", user);
		EditBasicInfoForm form = new EditBasicInfoForm();
		form.setUsername(user.getUsername());
		form.setFirstname(user.getFirstname());
		form.setLastname(user.getLastname());
		form.setEmail(user.getEmail());
		
		return new ModelAndView("members/editBasicInfo", "editBasicInfoForm", form);
	}
	
	// POST changed basic info form
	@RequestMapping(value = "/members/editBasicInfo/{memberId}/save", method = RequestMethod.POST)
	@Secured(value = "ROLE_USER")
	public ModelAndView saveBasicInfoPost(
			Model model,
			HttpServletRequest req,
			@PathVariable("memberId") String memberId,
			@Valid @ModelAttribute("editBasicInfoForm") EditBasicInfoForm form, 
			BindingResult result) {
		
		logger.info("MembersController.saveBasicInfoPost()");
		
		if (result.hasErrors()) {
			System.err.println(String.format("Errors Detected: %s", result.getErrorCount()));
			for (ObjectError e : result.getAllErrors()) {
				System.err.println(e.getDefaultMessage());	
			}
			return new ModelAndView("members/editBasicInfo", "editBasicInfoForm", form);
		}
		
		User user = (User) req.getSession().getAttribute("user");
		
		user.setFirstname(form.getFirstname());
		user.setLastname(form.getLastname());
		user.setEmail(form.getEmail());
		user.setUsername(form.getUsername());
		
		userService.save(user);
		
		model.addAttribute("user", user);
		return new ModelAndView("members/members", "command", model);
		
	}
	
	// GET address info change form
	@RequestMapping(value = "/members/editAddressInfo/{addressId}/", method = RequestMethod.GET)
	@Secured(value = "ROLE_USER")
	public ModelAndView editAddressInfoGet(@PathVariable("addressId") String addressId, HttpServletRequest req) {
		logger.info("MembersController.editAddressInfoGet()");
		
		User user = (User) req.getSession().getAttribute("user");

		Address addr = user.getAddresses().get(0);
		
		EditAddressInfoForm form = new EditAddressInfoForm();
		form.setAddressLine1(addr.getLine1());
		form.setAddressLine2(addr.getLine2());
		form.setCity(addr.getCity());
		form.setPostalCode(addr.getPostalCode());
		form.setAddressType(addr.getType());
		form.setState(addr.getState());
		
		return new ModelAndView("members/editAddressInfo", "editAddressInfoForm", form);
	}
	
	// POST changed form
	@RequestMapping(value = "/members/editAddressInfo/{addressId}/save", method = RequestMethod.POST)
	@Secured(value = "ROLE_USER")
	public ModelAndView saveAddressInfoPost(
			Model model,
			HttpServletRequest req,
			@PathVariable("addressId") String addressId,
			@Valid @ModelAttribute("editAddressInfoForm") EditAddressInfoForm form, 
			BindingResult result) {
		
		logger.info("MembersController.saveAddressInfoPost()");
		
		if (result.hasErrors()) {
			System.err.println(String.format("Errors Detected: %s", result.getErrorCount()));
			for (ObjectError e : result.getAllErrors()) {
				System.err.println(e.getDefaultMessage());	
			}
			return new ModelAndView("members/editAddressInfo", "editAddressInfoForm", form);
		}
		
		User user = (User) req.getSession().getAttribute("user");
		
		Address addr = user.getAddresses().get(0);
		addr.setLine1(form.getAddressLine1());
		addr.setLine2(form.getAddressLine2());
		addr.setCity(form.getCity());
		addr.setState(form.getState());
		addr.setPostalCode(form.getPostalCode());
		
		userService.save(user);
		
		model.addAttribute("user", user);
		return new ModelAndView("members/members", "command", model);
		
	}
	
	// GET address info change form
	@RequestMapping(value = "/members/editPhoneInfo/{phoneId}/", method = RequestMethod.GET)
	@Secured(value = "ROLE_USER")
	public ModelAndView editPhoneInfoGet(@PathVariable("phoneId") String phoneId, HttpServletRequest req) {
		logger.info("MembersController.editPhoneInfoGet()");
		
		User user = (User) req.getSession().getAttribute("user");

		PhoneNumber phone = user.getPhoneNumbers().get(0);
		
		EditPhoneInfoForm form = new EditPhoneInfoForm();
		form.setPhoneNumber(phone.getNumber());
		form.setType(PhoneType.HOME);
		form.setExtension(phone.getExtension());
		
		return new ModelAndView("members/editPhoneInfo", "editPhoneInfoForm", form);
	}
	
	// POST changed form
	@RequestMapping(value = "/members/editPhoneInfo/{phoneId}/save", method = RequestMethod.POST)
	@Secured(value = "ROLE_USER")
	public ModelAndView savePhoneInfoPost(
			Model model,
			HttpServletRequest req,
			@PathVariable("phoneId") String phoneId,
			@Valid @ModelAttribute("editPhoneInfoForm") EditPhoneInfoForm form, 
			BindingResult result) {
		
		logger.info("MembersController.savePhoneInfoPost()");
		
		if (result.hasErrors()) {
			System.err.println(String.format("Errors Detected: %s", result.getErrorCount()));
			for (ObjectError e : result.getAllErrors()) {
				System.err.println(e.getDefaultMessage());	
			}
			return new ModelAndView("members/editPhoneInfo", "editPhoneInfoForm", form);
		}
		
		User user = (User) req.getSession().getAttribute("user");
		
		PhoneNumber phone = user.getPhoneNumbers().get(0);
		phone.setExtension(form.getExtension());
		phone.setNumber(form.getPhoneNumber());
				
		userService.save(user);
		
		model.addAttribute("user", user);
		return new ModelAndView("/members/members", "command", model);
		
	}
	
}
