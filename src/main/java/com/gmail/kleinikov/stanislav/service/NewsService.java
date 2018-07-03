package com.gmail.kleinikov.stanislav.service;

import java.util.List;

import com.gmail.kleinikov.stanislav.entity.News;

public interface NewsService {

	List<News> getNews();

	News createNews(News news);

	News getNews(long id);

}
