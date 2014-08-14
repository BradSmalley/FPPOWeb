package org.fictitiousprofession.spring.security;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

//@Component
public class FPPOAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse res, Authentication auth) throws IOException,	ServletException {
		
		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
		Iterator<? extends GrantedAuthority> iter = authorities.iterator();
		while (iter.hasNext()) {
			GrantedAuthority ga = iter.next();
			if (ga.getAuthority().equals("ADMIN_ROLE")) {
				req.getSession().setAttribute("admin", true);
				break;
			}
		}
		//TODO: Redirect to success?

	}

}
