package com.gmail.kleinikov.stanislav.dao.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.gmail.kleinikov.stanislav.entity.Hotel;
import com.gmail.kleinikov.stanislav.entity.Tour;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
@WebAppConfiguration
@Transactional
public class TourDaoImplTest {

	@Autowired
	private TourDaoImpl tourDao;

	@Test
	public void testFetchAll() {
		List<Tour> tours = tourDao.fetchAll();
		assertFalse(tours.isEmpty());
	}

	@Test
	public void testFetchTour() {
		// TODO test
	}

	@Test
	public void testGetHotels() {
		List<Hotel> hotels = tourDao.getHotels();
		System.out.println(hotels.toString());
		assertNotNull(hotels);
	}

}
