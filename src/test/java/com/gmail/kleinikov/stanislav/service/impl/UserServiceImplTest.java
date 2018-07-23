package com.gmail.kleinikov.stanislav.service.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.gmail.kleinikov.stanislav.dao.UserDao;
import com.gmail.kleinikov.stanislav.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml",
		"file:src/main/webapp/WEB-INF/appconfig-security.xml" })
@WebAppConfiguration
@Transactional
public class UserServiceImplTest {

	@Autowired
	private UserDao userDao;

	@Test
	public void testSave() {

	}

	@Test
	public void testFindByUsername() {
		User user = userDao.findByUsername("stas");
		assertEquals("stas", user.getUsername());
	}

}
