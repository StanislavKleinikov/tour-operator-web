package com.gmail.kleinikov.stanislav.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gmail.kleinikov.stanislav.dao.RoleDao;
import com.gmail.kleinikov.stanislav.entity.Role;

@Repository
public class RoleDaoImpl implements RoleDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Role getOne(long id) {
		Session session = sessionFactory.getCurrentSession();
		Role role = session.get(Role.class, id);
		return role;
	}

}
