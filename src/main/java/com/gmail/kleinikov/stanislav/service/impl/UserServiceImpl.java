package com.gmail.kleinikov.stanislav.service.impl;

import com.gmail.kleinikov.stanislav.entity.User;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gmail.kleinikov.stanislav.dao.UserDao;
import com.gmail.kleinikov.stanislav.service.ServiceNoSuchUserException;
import com.gmail.kleinikov.stanislav.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	@Transactional
	public User authorise(String login, String password) throws ServiceNoSuchUserException {
		User user = userDao.fetchByCredentials(login, password);
		if (user == null) {
			throw new ServiceNoSuchUserException();
		}
		return user;
	}

	@Override
	@Transactional
	public boolean logOut() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getUser(long id) throws ServiceNoSuchUserException {
		User user = userDao.getUser(id);
		if(user==null) {
			throw new ServiceNoSuchUserException();
		}
		return user;
	}

	@Override
	@Transactional
	public void saveUser(User user) {
		System.out.println(user.toString());
		userDao.saveUser(user);
	
	}
	
}
