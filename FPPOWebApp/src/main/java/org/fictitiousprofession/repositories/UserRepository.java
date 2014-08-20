package org.fictitiousprofession.repositories;

import java.util.List;

import org.fictitiousprofession.entities.User;

public interface UserRepository {

	User save(User user);
	User find(User user);
	User findUserByUsername(String username);
	List<User> findAll();
	
}
