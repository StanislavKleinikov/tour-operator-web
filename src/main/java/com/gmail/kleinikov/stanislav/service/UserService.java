package com.gmail.kleinikov.stanislav.service;

import com.gmail.kleinikov.stanislav.entity.User;
import com.gmail.kleinikov.stanislav.exception.ServiceNoSuchUserException;

public interface UserService {

	User authorise(String login, String password) throws ServiceNoSuchUserException;

	boolean logOut();
	
	User getUser(long id) throws ServiceNoSuchUserException;
	
	void saveUser(User user);
}
