package com.gmail.kleinikov.stanislav.service.impl;

import static com.gmail.kleinikov.stanislav.util.ConstantValue.ROLE_ADMIN;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gmail.kleinikov.stanislav.dao.RoleDao;
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
	private RoleDao roleDao;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	@Transactional
	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		Set<Role> roles = new HashSet<>();
		roles.add(roleDao.getOne(ROLE_ADMIN));
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
