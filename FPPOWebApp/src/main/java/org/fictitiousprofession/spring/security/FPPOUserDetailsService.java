package org.fictitiousprofession.spring.security;

import javax.persistence.NoResultException;

import org.fictitiousprofession.entities.User;
import org.fictitiousprofession.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class FPPOUserDetailsService implements UserDetailsService {

	@Autowired private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username)	throws UsernameNotFoundException {
		
		User user = null;
		try {
			user = userService.findUserByUsername(username);
		} catch (NoResultException e) {
			throw new UsernameNotFoundException("");
		}

		FPPOUserDetails details = new FPPOUserDetails();
		details.setUser(user);
		
		return details;
	}

}
