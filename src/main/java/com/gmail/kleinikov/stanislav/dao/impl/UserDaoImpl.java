package com.gmail.kleinikov.stanislav.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gmail.kleinikov.stanislav.dao.UserDao;
import com.gmail.kleinikov.stanislav.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User findByUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		Query<User> query = session.createQuery("from User where username=:username", User.class);
		query.setParameter("username", username);
		User user = null;
		try {
			user = (User) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
		return user;
	}

	@Override
	public List<User> findAll() {
		Session session = sessionFactory.getCurrentSession();
		Query<User> query = session.createQuery("from User", User.class);
		List<User> users = query.getResultList();
		return users;
	}

	@Override
	public void save(User user) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println(user);
		session.save(user);
	}

}
