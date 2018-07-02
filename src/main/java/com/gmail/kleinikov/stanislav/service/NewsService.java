package com.gmail.kleinikov.stanislav.service;

import java.util.List;

import com.gmail.kleinikov.stanislav.entity.News;

public interface NewsService {

	List<News> actualNewsList();
	
	List<News> getNews();

	News createNews(News news);

}
