package com.gmail.kleinikov.stanislav.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gmail.kleinikov.stanislav.entity.User;

public interface UserDao extends JpaRepository<User, Long> {
	User findByUsername(String username);

}
