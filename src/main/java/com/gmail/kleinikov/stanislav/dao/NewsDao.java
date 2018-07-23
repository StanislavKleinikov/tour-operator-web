package com.gmail.kleinikov.stanislav.dao;

import java.util.List;

import com.gmail.kleinikov.stanislav.entity.News;

public interface NewsDao {

	News createNews(News news);

	List<News> getNews();

	News getNewsById(long id);

	void deleteNews(long id);

	void saveNews(News news);
}
