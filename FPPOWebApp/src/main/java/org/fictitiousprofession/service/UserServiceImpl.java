package org.fictitiousprofession.service;

import org.fictitiousprofession.entities.User;
import org.fictitiousprofession.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired private UserRepository userRepository;
	
	@Override
	public User save(User user) {
		userRepository.save(user);
		return user;
	}

	@Override
	public User find(User user) {
		return userRepository.find(user);
	}
	
	@Override
	public User findUserById(Integer id) {
		User user = new User();
		user.setId(id);
		return find(user);
	}

	@Override
	public User findUserByUsername(String username) {
		return userRepository.findUserByUsername(username);
	}

}
