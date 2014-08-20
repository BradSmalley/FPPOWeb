package org.fictitiousprofession.service;

import java.util.Date;
import java.util.List;

import org.fictitiousprofession.entities.Address;
import org.fictitiousprofession.entities.AddressType;
import org.fictitiousprofession.entities.PhoneNumber;
import org.fictitiousprofession.entities.Role;
import org.fictitiousprofession.entities.User;
import org.fictitiousprofession.repositories.UserRepository;
import org.fictitiousprofession.web.form.RegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired private UserRepository userRepository;
	@Autowired private PasswordEncoder encoder;
	
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
	public List<User> findAll() {
		return userRepository.findAll();
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
	
	
	public User register(RegistrationForm form) {

		User user = new User();
		
		user.setEmail(form.getEmail());
		user.setFirstname(form.getFirstname());
		user.setLastname(form.getLastname());
		user.setPassword(encoder.encode(form.getPassword()));
		user.setRegistrationDate(new Date());
		user.setUsername(form.getUsername());	
		user.setPaid(false); //TODO:  ??

		userRepository.save(user);
		
		Address address = new Address();
		address.setUserId(user.getId());
		address.setType(AddressType.SHIPPING); //TODO:  ???
		address.setLine1(form.getAddressLine1());
		address.setLine2(form.getAddressLine2());
		address.setCity(form.getCity());
		address.setState(form.getState());
		address.setPostalCode(form.getPostalCode());
		
		PhoneNumber phone = new PhoneNumber(form.getPhoneNumber());
		phone.setUserId(user.getId());
		
		Role role = new Role();
		role.setUserId(user.getId());
		role.setRole("ROLE_USER");

		user.getAddresses().add(address);
		user.getPhoneNumbers().add(phone);
		user.getRoles().add(role);
		
		userRepository.save(user);
		
		return user;
		
	}
	
	

}
