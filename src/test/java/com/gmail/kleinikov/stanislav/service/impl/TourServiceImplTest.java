package com.gmail.kleinikov.stanislav.service.impl;

import static com.gmail.kleinikov.stanislav.util.ConstantValue.FILTER_PARAM_CATEGORY;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.FILTER_PARAM_COUNTRY;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.FILTER_PARAM_DEPARTURE;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.FILTER_PARAM_ENDDATE;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.FILTER_PARAM_MAXDAY;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.FILTER_PARAM_MINDAY;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.FILTER_PARAM_NUTRITION;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.FILTER_PARAM_STARTDATE;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.gmail.kleinikov.stanislav.entity.Tour;
import com.gmail.kleinikov.stanislav.service.TourService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
@WebAppConfiguration
@Transactional
public class TourServiceImplTest {

	@Autowired
	private TourService tourService;

	@Test
	public void testSearchTour() {
		Map<String, String> parameters = new HashMap<>();
		parameters.put(FILTER_PARAM_COUNTRY, "Вьетнам");
		parameters.put(FILTER_PARAM_DEPARTURE, "Москва");
		parameters.put(FILTER_PARAM_NUTRITION, "FB");
		parameters.put(FILTER_PARAM_CATEGORY, "2");
		parameters.put(FILTER_PARAM_STARTDATE, "2018-08-22");
		parameters.put(FILTER_PARAM_ENDDATE, "2018-08-30");
		parameters.put(FILTER_PARAM_MINDAY, "7");
		parameters.put(FILTER_PARAM_MAXDAY, "10");

		List<Tour> tours = tourService.searchTour(parameters);
		assertNotNull(tours);
	}
}
