package org.fictitiousprofession.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminController extends AbstractBaseController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@RequestMapping(method = RequestMethod.GET)
	public String home() {
		logger.info("AdminController.home()");
		
		return "admin/home";
	}
	
	@RequestMapping(value = "listUsers", method = RequestMethod.GET)
	public String listUsers(Model model) {
		
		model.addAttribute("users", userService.findAll());
		
		return "admin/listUsers";
	}
	
	@RequestMapping(value = "manageUser", method = RequestMethod.GET)
	public String manageUser(Model model, @RequestParam("userId") String userId) {
		
		model.addAttribute("selectedUser", userService.findUserById(Integer.valueOf(userId)));
		
		return "admin/manageUser";
	}
	
}
