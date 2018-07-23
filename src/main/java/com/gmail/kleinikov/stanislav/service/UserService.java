package com.gmail.kleinikov.stanislav.service;

import java.util.List;

import com.gmail.kleinikov.stanislav.entity.User;

/**
 * Service class for {@link com.gmail.kleinikov.stanislav.entity.User}
 *
 * @author Stanislav Kleinikov
 * @version 1.0
 */

public interface UserService {

	void save(User user);

	User findByUsername(String username);

	List<User> fetchAll();
}
