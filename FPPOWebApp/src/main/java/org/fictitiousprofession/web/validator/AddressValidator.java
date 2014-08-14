package org.fictitiousprofession.web.validator;

import org.fictitiousprofession.entities.Address;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class AddressValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Address.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors e) {
		Address address = (Address) target;
		ValidationUtils.rejectIfEmpty(e, "line1", "line1.required");
		ValidationUtils.rejectIfEmpty(e, "city", "city.required");
		if (address.getCity().length() > 45) {
			e.rejectValue("city", "city.tooLong");
		}

	}

}
