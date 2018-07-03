package com.gmail.kleinikov.stanislav.dao.impl;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.gmail.kleinikov.stanislav.dao.NewsDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
@WebAppConfiguration
@Transactional
public class NewsDaoImplTest {

	@Autowired
	private NewsDao newsDao;

	@Test
	public void testGetNews() {
		// TODO Test
	}

	@Test
	public void testCreateNews() {
		// TODO Test
	}

	@Test
	public void testGetNewsById() {
		assertNotNull(newsDao.getNewsById(1));
	}

}
