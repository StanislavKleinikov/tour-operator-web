package com.gmail.kleinikov.stanislav.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gmail.kleinikov.stanislav.dao.NewsDao;
import com.gmail.kleinikov.stanislav.entity.News;

/**
 * Implementation of {@link NewsDao} interface.
 *
 * @author Kleinikov Stanislav
 * @version 1.0
 */
@Repository
public class NewsDaoImpl implements NewsDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<News> getNews() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<News> query = currentSession.createQuery("from News", News.class);
		List<News> news = query.getResultList();
		return news;
	}

	@Override
	public News getNewsById(long id) {
		Session currentSession = sessionFactory.getCurrentSession();
		News news = currentSession.get(News.class, id);
		return news;
	}

	@Override
	public News createNews(News news) {
		Session currentSession = sessionFactory.getCurrentSession();
		Long id = (Long) currentSession.save(news);
		return currentSession.get(News.class, id);
	}

	@Override
	public void deleteNews(long id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("delete from News where id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

	@Override
	public void saveNews(News news) {
		Session currentSession = sessionFactory.getCurrentSession();
		System.out.println(news);
		currentSession.saveOrUpdate(news);
	}

}
