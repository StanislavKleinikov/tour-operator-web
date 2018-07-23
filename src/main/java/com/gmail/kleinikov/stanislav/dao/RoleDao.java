package com.gmail.kleinikov.stanislav.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gmail.kleinikov.stanislav.entity.Role;

public interface RoleDao extends JpaRepository<Role, Long> {
}
