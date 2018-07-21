package com.gmail.kleinikov.stanislav.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gmail.kleinikov.stanislav.dao.NewsDao;
import com.gmail.kleinikov.stanislav.entity.News;
import com.gmail.kleinikov.stanislav.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsDao newsDao;

	private List<News> actualNewsList() {
		List<News> news = newsDao.getNews();
		news = news.stream().filter(x -> "active".equalsIgnoreCase(x.getStatus().getName()))
				.sorted((x1, x2) -> x2.getDate().compareTo(x1.getDate())).collect(Collectors.toList());
		return news;
	}

	@Override
	@Transactional
	public List<News> getNews() {
		List<News> news = actualNewsList();
		return news;
	}

	@Override
	@Transactional
	public List<News> getAllNews() {
		List<News> news = newsDao.getNews();
		return news;
	}

	@Override
	@Transactional
	public void createNews(News news) {
		newsDao.createNews(news);
	}

	@Override
	@Transactional
	public News getNews(long id) {
		News news = newsDao.getNewsById(id);
		return news;
	}

	@Override
	@Transactional
	public void updateNews(News news) {
		newsDao.updateNews(news);
	}

	@Override
	@Transactional
	public void deleteNews(long id) {
		newsDao.deleteNews(id);
	}
}
