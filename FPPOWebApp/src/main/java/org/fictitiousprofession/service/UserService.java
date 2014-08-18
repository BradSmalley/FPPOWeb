package org.fictitiousprofession.service;

import org.fictitiousprofession.entities.User;

public interface UserService {

	User save(User user);
	User find(User user);
	User findUserById(Integer id);
	User findUserByUsername(String username);
	
}
