package org.fictitiousprofession.web;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MembersController {
	
	private static final Logger logger = LoggerFactory.getLogger(MembersController.class);
	@Autowired private ApplicationContext context;

	@RequestMapping(value = "/members", method = RequestMethod.GET)
	@Secured(value = "ROLE_USER")
	public String members(Model model, HttpServletRequest req, HttpServletResponse resp) {
		logger.info("MembersController.members()");
		
//		model.addAttribute("beans", context.getParent().getBeanDefinitionNames());
		
//		Enumeration<String> e = req.getSession().getAttributeNames();
//		while (e.hasMoreElements()) {
//			System.out.println(e.nextElement());
//		}
		SecurityContext secContext = (SecurityContext) req.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
		Authentication auth = secContext.getAuthentication();
		Iterator<? extends GrantedAuthority> iter = auth.getAuthorities().iterator();
		List<String> auths = new ArrayList<String>();
		while (iter.hasNext()) {
			GrantedAuthority ga = iter.next();
			auths.add(ga.getAuthority());
		}
		model.addAttribute("auths", auths);
		
		return "member/members";
	}
	
	@RequestMapping(value = "/members/edit/{memberId}/", method = RequestMethod.GET)
	public String editMember(@PathVariable("memberId") String memberId, Model model) {
		logger.info("MembersController.editMember()");
		
		model.addAttribute("memberId", memberId);
		
		return "editMember";
	}
	
}
