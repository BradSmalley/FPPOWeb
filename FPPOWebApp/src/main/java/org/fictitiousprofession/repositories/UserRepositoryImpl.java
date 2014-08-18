package org.fictitiousprofession.repositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.fictitiousprofession.entities.User;
import org.springframework.stereotype.Component;

@Component("userRepository")
public class UserRepositoryImpl implements UserRepository {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public UserRepositoryImpl() {
		emf = Persistence.createEntityManagerFactory("FPPOWebApp");
		em = emf.createEntityManager();
	}
	
	
	@Override
	public User find(User user) {
		if (user.getId() == null) {
			throw new IllegalArgumentException("userId cannot be null");
		}
		return em.find(User.class, user.getId());
	}
	
	@Override
	public User save(User user) {
		
		em.getTransaction().begin();
		if (em.contains(user)) {
			em.merge(user);
		} else {
			em.persist(user);
		}
		em.flush();
		em.getTransaction().commit();
		
		return user;
	}
	
	@Override
	public User findUserByUsername(String username) {
		em.clear();
		TypedQuery<User> query = em.createNamedQuery("User.findUserByUsername", User.class);
		User user = query.setParameter("username", username).getSingleResult();
		return user;
	}





}
