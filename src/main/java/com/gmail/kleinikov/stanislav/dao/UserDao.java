package com.gmail.kleinikov.stanislav.dao;

import java.util.List;

import com.gmail.kleinikov.stanislav.entity.User;

public interface UserDao {
	User findByUsername(String username);

	List<User> findAll();

	void save(User user);

}
