package com.gmail.kleinikov.stanislav.dao.impl;

import com.gmail.kleinikov.stanislav.entity.User;
import com.mysql.jdbc.PreparedStatement;

import java.sql.ResultSet;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gmail.kleinikov.stanislav.dao.UserDao;


@Repository
public class UserDaoImpl implements UserDao {


	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User fetchByCredentials(String login, String password) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query<User> query = currentSession.createQuery("from User as s where s.login=:login and s.password=:password",User.class);
		query.setParameter("login", login);
		query.setParameter("password", password);
		User user = query.getSingleResult();
		return user;
	}

	@Override
	public User getUser(long id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
			
		User user = currentSession.get(User.class, id);
		
		return user;
	}
	
	@Override
	public void saveUser(User user) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(user);
	}
}
