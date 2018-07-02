package com.gmail.kleinikov.stanislav.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gmail.kleinikov.stanislav.entity.News;
import com.gmail.kleinikov.stanislav.dao.NewsDao;

@Repository
public class NewsDaoImpl implements NewsDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<News> getNews() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query 		
		Query<News> query = 
				currentSession.createQuery("from News",
											News.class);

		// execute query and get result list
		List<News> news = query.getResultList();
		return news;
	}


	@Override
	public News createNews(News news) {
		// TODO Auto-generated method stub
		return null;
	}
}
