//package org.fictitiousprofession.web;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//@Controller
//@RequestMapping("/login")
//public class LoginController {
//
//	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
//	@Autowired private PasswordEncoder encoder;
//
//	@RequestMapping(method = RequestMethod.GET)
//	public String login() {
//		logger.info("LoginController.login()");
//		return "login/login";
//	}
//	
//	@RequestMapping(method = RequestMethod.POST)
//	public String loginPost() {
//		logger.info("LoginController.loginPost()");
//		return "login/login";
//	}
//}
