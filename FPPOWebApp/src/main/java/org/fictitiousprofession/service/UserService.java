package org.fictitiousprofession.service;

import java.util.List;

import org.fictitiousprofession.entities.User;
import org.fictitiousprofession.web.form.RegistrationForm;

public interface UserService {

	User save(User user);
	User find(User user);
	List<User> findAll();
	User findUserById(Integer id);
	User findUserByUsername(String username);
	User register(RegistrationForm form);

}
