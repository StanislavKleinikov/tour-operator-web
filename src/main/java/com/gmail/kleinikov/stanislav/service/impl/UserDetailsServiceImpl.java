package com.gmail.kleinikov.stanislav.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gmail.kleinikov.stanislav.entity.Role;
import com.gmail.kleinikov.stanislav.entity.User;
import com.gmail.kleinikov.stanislav.service.UserService;

/**
 * Implementation of
 * {@link org.springframework.security.core.userdetails.UserDetailsService}
 * interface.
 *
 * @author Stanislav Kleinikov
 * @version 1.0
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserService userService;

	/**
	 * Locates the user based on the username.
	 * 
	 * @param username
	 *            - the username identifying the user whose data is required.
	 *
	 * @return a fully populated user record (never <code>null</code>)
	 *
	 * @throws UsernameNotFoundException
	 *             if the user could not be found or the user has no
	 *             GrantedAuthority
	 */
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.findByUsername(username);

		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

		for (Role role : user.getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				grantedAuthorities);
	}
}
