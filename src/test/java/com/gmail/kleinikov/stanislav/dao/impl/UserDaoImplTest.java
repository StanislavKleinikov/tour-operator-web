package com.gmail.kleinikov.stanislav.dao.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.gmail.kleinikov.stanislav.dao.UserDao;
import com.gmail.kleinikov.stanislav.entity.Role;
import com.gmail.kleinikov.stanislav.entity.Status;
import com.gmail.kleinikov.stanislav.entity.User;
import com.gmail.kleinikov.stanislav.entity.UserDetail;

import static com.gmail.kleinikov.stanislav.util.ConstantValue.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/applicationContext.xml"})
@WebAppConfiguration
@Transactional
public class UserDaoImplTest {

	@Autowired
	private UserDao userDao;
	
	@Test
	public void testFetchByCredential() {
		User user = userDao.fetchByCredentials("admin","admin");
		assertNotNull(user);
		System.out.println(user);
	}
	
	@Test
	public void testGetUser() {
		User user = userDao.getUser(1);
		assertNotNull(user);
	}
	
	@Test
	public void testSaveUser() {
		User user = new User();
		
		user.setLogin("test");
		user.setPassword("test");
		user.setRole(new Role(ROLE_USER));
		user.setStatus(new Status(STATUS_ACTIVE));
		
		UserDetail detail = new UserDetail();
		detail.setEmail("test@gmail.com");
		detail.setFirstName("test");
		detail.setLastName("test");
		detail.setPhoneNumber("00000000000");
		
		user.setUserDetail(detail);
		userDao.saveUser(user);
	}
}
