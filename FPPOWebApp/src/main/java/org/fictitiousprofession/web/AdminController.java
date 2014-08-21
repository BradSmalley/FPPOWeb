package org.fictitiousprofession.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.fictitiousprofession.entities.Address;
import org.fictitiousprofession.entities.PhoneNumber;
import org.fictitiousprofession.entities.Role;
import org.fictitiousprofession.entities.User;
import org.fictitiousprofession.web.form.AdminEditBasicInfoForm;
import org.fictitiousprofession.web.form.EditAddressInfoForm;
import org.fictitiousprofession.web.form.EditPhoneInfoForm;
import org.fictitiousprofession.web.form.EditRoleInfoForm;
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
	
	@RequestMapping(value = "adminEditPhoneInfo", method = RequestMethod.GET)
	@Secured("ROLE_ADMIN")
	public EditPhoneInfoForm adminEditPhoneInfoGet(@RequestParam("userId") String userId) {
		
		User user = userService.findUserById(Integer.valueOf(userId));
		
		EditPhoneInfoForm form = new EditPhoneInfoForm();
		PhoneNumber phone = user.getPhoneNumbers().get(0);
		form.setPhoneNumber(phone.getNumber());
		form.setExtension(phone.getExtension());
		form.setUserId(user.getId());
		
		return form;
	}
	
	@RequestMapping(value = "adminEditPhoneInfo", method = RequestMethod.POST)
	@Secured("ROLE_ADMIN")
	public String adminEditPhoneInfoPost(Model model, @RequestParam("userId") String userId,
			@Valid @ModelAttribute EditPhoneInfoForm form, BindingResult result) {
		
		if (result.hasErrors()) {
			return "admin/adminEditPhoneInfo";
		}
	
		User user = userService.findUserById(Integer.valueOf(userId));
		PhoneNumber phone = user.getPhoneNumbers().get(0);
		
		phone.setExtension(form.getExtension());
		phone.setNumber(form.getPhoneNumber());
				
		userService.save(user);
		
		model.addAttribute("selectedUser", user);
		return "admin/manageUser";
	}
	
	@RequestMapping(value = "adminEditRoleInfo", method = RequestMethod.GET)
	@Secured("ROLE_ADMIN")
	public EditRoleInfoForm adminEditRoleInfoGet(@RequestParam("userId") String userId) {
		
		User user = userService.findUserById(Integer.valueOf(userId));
		
		EditRoleInfoForm form = new EditRoleInfoForm();
		for (Role role : user.getRoles()) {
			if (role.getRole().equalsIgnoreCase("ROLE_ADMIN")) {
				form.setAdmin(true);
				break;
			}
		}
		form.setUserId(user.getId());
		
		return form;
	}
	
	@RequestMapping(value = "adminEditRoleInfo", method = RequestMethod.POST)
	@Secured("ROLE_ADMIN")
	public String adminEditRoleInfoPost(Model model, @RequestParam("userId") String userId,
			@Valid @ModelAttribute EditRoleInfoForm form, BindingResult result) {
		
		if (result.hasErrors()) {
			return "admin/adminEditRoleInfo";
		}
	
		User user = userService.findUserById(Integer.valueOf(userId));
		boolean hasAdminRole = false;
		int roleIndex = 0;
		List<Role> roles = user.getRoles();
		for (int x = 0 ; x < roles.size() ; x++ ) {
			if (roles.get(x).getRole().equalsIgnoreCase("ROLE_ADMIN")) {
				hasAdminRole = true;
				roleIndex = x;
				break;
			}
		}
		
		if (!hasAdminRole && form.isAdmin()) {
			user.getRoles().add(new Role("ROLE_ADMIN", user.getId()));	
		}
		if (hasAdminRole && !form.isAdmin()) {
			user.getRoles().remove(roleIndex);
		}
		
		userService.save(user);
		
		model.addAttribute("selectedUser", user);
		return "admin/manageUser";
	}
	
}
