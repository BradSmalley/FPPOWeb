package org.fictitiousprofession.web;

import java.text.DateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.fictitiousprofession.entities.Address;
import org.fictitiousprofession.entities.User;
import org.fictitiousprofession.web.form.AdminEditBasicInfoForm;
import org.fictitiousprofession.web.form.EditAddressInfoForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminController extends AbstractBaseController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@RequestMapping(method = RequestMethod.GET)
	@Secured("ROLE_ADMIN")
	public String home() {
		logger.info("AdminController.home()");
		
		return "admin/home";
	}
	
	@RequestMapping(value = "listUsers", method = RequestMethod.GET)
	@Secured("ROLE_ADMIN")
	public String listUsers(Model model) {
		
		model.addAttribute("users", userService.findAll());
		
		return "admin/listUsers";
	}
	
	@RequestMapping(value = "manageUser", method = RequestMethod.GET)
	@Secured("ROLE_ADMIN")
	public String manageUser(Model model, @RequestParam("userId") String userId) {
		
		model.addAttribute("selectedUser", userService.findUserById(Integer.valueOf(userId)));
		
		return "admin/manageUser";
	}
	
	@RequestMapping(value = "adminEditBasicInfo", method = RequestMethod.GET)
	@Secured("ROLE_ADMIN")
	public AdminEditBasicInfoForm adminEditBasicInfoGet(@RequestParam("userId") String userId) {
	
		User user = userService.findUserById(Integer.valueOf(userId));
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
		
		AdminEditBasicInfoForm form = new AdminEditBasicInfoForm();
		form.setEmail(user.getEmail());
		form.setFirstname(user.getFirstname());
		form.setLastname(user.getLastname());
		
		if (user.getLastPaymentDate() != null) {
			form.setLastPaymentDate(df.format(user.getLastPaymentDate()));
		}
		form.setPaid(user.getPaid());
		form.setRegistrationDate(user.getRegistrationDate());
		form.setUsername(user.getUsername());
		
		return form;
	}
	
	@RequestMapping(value = "adminEditBasicInfo", method = RequestMethod.POST)
	@Secured("ROLE_ADMIN")
	public String adminEditBasicInfoPost(Model model, 
			@Valid @ModelAttribute AdminEditBasicInfoForm form, BindingResult results) {
		
		if (results.hasErrors()) {
			return "admin/adminEditBasicInfo";
		}
		
		User user = userService.findUserByUsername(form.getUsername());
		user.setEmail(form.getEmail());
		user.setFirstname(form.getFirstname());
		user.setLastname(form.getLastname());
		user.setPaid(form.isPaid());
		if (form.getLastPaymentDate() != null && form.getLastPaymentDate().trim().length() > 0) {
			DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
			Date lastPaymentDate = new Date();
			try {
				lastPaymentDate = df.parse(form.getLastPaymentDate());
			} catch (Exception e) {}
			user.setLastPaymentDate(lastPaymentDate);
		}
		
		userService.save(user);
		
		model.addAttribute("selectedUser", user);
		return "admin/manageUser";
	}
	
	@RequestMapping(value = "adminEditAddressInfo", method = RequestMethod.GET)
	@Secured("ROLE_ADMIN")
	public EditAddressInfoForm adminEditAddressInfoGet(@RequestParam("userId") String userId) {
		
		User user = userService.findUserById(Integer.valueOf(userId));
		
		EditAddressInfoForm form = new EditAddressInfoForm();
		Address address = user.getAddresses().get(0);
		form.setAddressLine1(address.getLine1());
		form.setAddressLine2(address.getLine2());
		form.setAddressType(address.getType());
		form.setCity(address.getCity());
		form.setPostalCode(address.getPostalCode());
		form.setState(address.getState());
		form.setUserId(user.getId());
		
		return form;
	}
	
	@RequestMapping(value = "adminEditAddressInfo", method = RequestMethod.POST)
	@Secured("ROLE_ADMIN")
	public String adminEditAddressInfoPost(Model model, @RequestParam("userId") String userId,
			@Valid @ModelAttribute EditAddressInfoForm form, BindingResult result) {
		
		if (result.hasErrors()) {
			return "admin/adminEditAddressInfo";
		}
	
		User user = userService.findUserById(Integer.valueOf(userId));
		Address address = user.getAddresses().get(0);
		
		address.setCity(form.getCity());
		address.setLine1(form.getAddressLine1());
		address.setLine2(form.getAddressLine2());
		address.setPostalCode(form.getPostalCode());
		address.setState(form.getState());
		
		userService.save(user);
		
		model.addAttribute("selectedUser", user);
		return "admin/manageUser";
	}
	
	
	
}
