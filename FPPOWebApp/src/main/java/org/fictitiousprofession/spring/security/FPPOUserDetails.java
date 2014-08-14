package org.fictitiousprofession.spring.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.fictitiousprofession.entities.Role;
import org.fictitiousprofession.entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class FPPOUserDetails implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	private User user;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
		for (final Role role : user.getRoles()) {
			System.err.println(role.getRole());
			auths.add(new GrantedAuthority() {
				private static final long serialVersionUID = 1L;
				@Override
				public String getAuthority() {
					return role.getRole();
				}
			});
		}
		return auths;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {	
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}
