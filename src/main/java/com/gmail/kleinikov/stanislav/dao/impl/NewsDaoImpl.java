package com.gmail.kleinikov.stanislav.dao.impl;

import static com.gmail.kleinikov.stanislav.util.ConstantValue.STATUS_DELETED;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gmail.kleinikov.stanislav.dao.NewsDao;
import com.gmail.kleinikov.stanislav.entity.News;
import com.gmail.kleinikov.stanislav.entity.Status;

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
	public News deleteNews(long id) {
		Session currentSession = sessionFactory.getCurrentSession();
		News news = currentSession.get(News.class, id);
		Status status = currentSession.get(Status.class, STATUS_DELETED);
		news.setStatus(status);
		currentSession.update(news);
		return currentSession.get(News.class, id);
	}

	@Override
	public void updateNews(News news) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.update(news);
	}

}
