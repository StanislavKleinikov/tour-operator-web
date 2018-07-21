package com.gmail.kleinikov.stanislav.service;

import java.util.List;

import com.gmail.kleinikov.stanislav.entity.News;

public interface NewsService {

	List<News> getNews();

	List<News> getAllNews();

	void createNews(News news);

	void updateNews(News news);

	void deleteNews(long id);

	News getNews(long id);

}
