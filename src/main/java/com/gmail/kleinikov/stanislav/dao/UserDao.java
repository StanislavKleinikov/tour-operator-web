package com.gmail.kleinikov.stanislav.dao;

import com.gmail.kleinikov.stanislav.entity.User;

public interface UserDao {

	User fetchByCredentials(String login, String password);
	
	User getUser(long id);
	
	void saveUser(User user);
}
