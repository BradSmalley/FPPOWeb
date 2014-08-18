package org.fictitiousprofession.web;

import org.fictitiousprofession.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractBaseController {

	@Autowired protected UserService userService;
	
}
