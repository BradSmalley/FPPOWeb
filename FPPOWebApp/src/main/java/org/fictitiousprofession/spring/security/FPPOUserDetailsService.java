package org.fictitiousprofession.spring.security;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import org.fictitiousprofession.entities.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class FPPOUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username)	throws UsernameNotFoundException {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("FPPOWebApp");
		EntityManager em = factory.createEntityManager();

		em.clear();
		
		User user = null;
		try {
			user = (User) em.createQuery("SELECT u FROM User u WHERE u.username = :username")
			    .setParameter("username", username.trim())
			    .getSingleResult();
		} catch (NoResultException e) {
			throw new UsernameNotFoundException("");
		}

		
		FPPOUserDetails details = new FPPOUserDetails();
		details.setUser(user);
		
		return details;
	}

}
