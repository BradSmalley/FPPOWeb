package org.fictitiousprofession.spring.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class FPPOPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			
			byte[] hash = md.digest(rawPassword.toString().getBytes());
			
			return Base64.encodeBase64String(hash);

		} catch (NoSuchAlgorithmException e) {
			System.err.println("No SHA-256 implementation found.  Program will not work.");
		}
		return null;
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {	
		return encode(rawPassword).trim().equals(encodedPassword.trim());
	}

}
