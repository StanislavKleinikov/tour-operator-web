package com.gmail.kleinikov.stanislav.service.impl;

import static com.gmail.kleinikov.stanislav.util.ConstantValue.ROLE_USER;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gmail.kleinikov.stanislav.dao.UserDao;
import com.gmail.kleinikov.stanislav.entity.Role;
import com.gmail.kleinikov.stanislav.entity.User;
import com.gmail.kleinikov.stanislav.service.UserService;

/**
 * Implementation of {@link UserService} interface.
 *
 * @author Kleinikov Stanislav
 * @version 1.0
 */

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	/**
	 * Encrypts password of the {@link User}, sets default {@link Role} as
	 * ROLE_ADMIN and invokes the method 'save' of the userDao.
	 *
	 * @param user
	 *            - The User to be save.
	 * @see BCryptPasswordEncoder
	 * @see HashSet
	 * @see Role
	 */
	@Override
	@Transactional
	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		Set<Role> roles = new HashSet<>();
		Role role = new Role();
		role.setId(ROLE_USER);
		roles.add(role);
		user.setRoles(roles);
		userDao.save(user);
	}

	@Override
	@Transactional
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	@Transactional
	public List<User> fetchAll() {
		List<User> users = userDao.findAll();
		return users;
	}

}
