package com.gmail.kleinikov.stanislav.service;

import java.util.List;

import com.gmail.kleinikov.stanislav.entity.News;

/**
 * Service class for {@link com.gmail.kleinikov.stanislav.entity.News}
 *
 * @author Stanislav Kleinikov
 * @version 1.0
 */

public interface NewsService {

	List<News> getNews();

	List<News> getAllNews();

	void createNews(News news);

	void saveNews(News news);

	void deleteNews(long id);

	News getNews(long id);

}
