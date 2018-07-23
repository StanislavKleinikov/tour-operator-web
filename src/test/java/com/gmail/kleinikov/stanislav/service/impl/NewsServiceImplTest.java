package com.gmail.kleinikov.stanislav.service.impl;

import static com.gmail.kleinikov.stanislav.util.ConstantValue.STATUS_ACTIVE;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.gmail.kleinikov.stanislav.dao.NewsDao;
import com.gmail.kleinikov.stanislav.entity.News;
import com.gmail.kleinikov.stanislav.entity.Status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml",
		"file:src/main/webapp/WEB-INF/appconfig-security.xml" })
@WebAppConfiguration
@Transactional
public class NewsServiceImplTest {

	@Autowired
	private NewsDao newsDao;

	@Test
	public void testGetNews() {

	}

	@Test
	public void testGetAllNews() {
		List<News> news = newsDao.getNews();
		System.out.println(news);
		assertNotNull(news);
	}

	@Test
	public void testCreateNews() {
		News news = new News();
		news.setText("Test Text");
		news.setTopic("test");
		Status status = new Status();
		status.setId(STATUS_ACTIVE);
		news.setStatus(status);
		News resulNews = newsDao.createNews(news);
		assertSame(news.getText(), resulNews.getText());
		assertSame(news.getStatus(), resulNews.getStatus());
		assertSame(news.getTopic(), resulNews.getTopic());
	}

	@Test
	public void testGetNewsLong() {

	}

	@Test
	public void testUpdateNews() {

	}

	@Test
	public void testDeleteNews() {

	}

}
