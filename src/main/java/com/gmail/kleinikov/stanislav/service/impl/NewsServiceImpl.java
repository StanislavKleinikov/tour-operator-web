package com.gmail.kleinikov.stanislav.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gmail.kleinikov.stanislav.entity.News;
import com.gmail.kleinikov.stanislav.dao.NewsDao;
import com.gmail.kleinikov.stanislav.service.NewsService;

import static com.gmail.kleinikov.stanislav.util.ConstantValue.*;

@Service
public class NewsServiceImpl implements NewsService {
	
	@Autowired
	private NewsDao newsDao;

	@Override
	//@Transactional
	public List<News> actualNewsList() {
		List<News> news = newsDao.getNews();
		news = news.stream().filter(x -> "active".equalsIgnoreCase(x.getStatus().getName()))
				.sorted((x1, x2) -> x2.getDate().compareTo(x1.getDate())).collect(Collectors.toList());
		return news;
	}

	@Override
	@Transactional
	public List<News> getNews() {
		List<News> news = actualNewsList().stream().limit(NEWS_PER_PAGE).collect(Collectors.toList());
		return news;
	}
		
	@Override
	@Transactional
	public News createNews(News news) {
		// TODO Auto-generated method stub
		return null;
	}

}