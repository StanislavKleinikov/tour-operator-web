package com.gmail.kleinikov.stanislav.dao.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gmail.kleinikov.stanislav.dao.TourDao;
import com.gmail.kleinikov.stanislav.entity.Hotel;
import com.gmail.kleinikov.stanislav.entity.Tour;

@Repository
public class TourDaoImpl implements TourDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Tour> fetchAll() {
		Session session = sessionFactory.getCurrentSession();
		Query<Tour> query = session.createQuery("from Tour", Tour.class);
		List<Tour> tours = query.getResultList();
		return tours;
	}

	@Override
	public Tour fetchTour(long id) {
		Session session = sessionFactory.getCurrentSession();
		Tour tour = session.get(Tour.class, id);
		return tour;
	}

	public List<Hotel> getHotels() {
		Session session = sessionFactory.getCurrentSession();
		Query<Hotel> query = session.createQuery("from Hotel", Hotel.class);
		List<Hotel> hotels = query.getResultList();
		return hotels;
	}

	public List<Tour> searchTour(Map<String, String> parameters) {

		Session session = sessionFactory.getCurrentSession();

		Set<Filter> filters = enableFilters(parameters, session);

		Query<Tour> query = session.createQuery("from Tour", Tour.class);
		List<Tour> tours = query.getResultList();

		disableFilters(filters, session);

		return tours;
	}

	private Set<Filter> enableFilters(Map<String, String> parameters, Session session) {
		Set<Filter> filters = new HashSet<>();
		if (parameters.containsKey("departure_country")) {
			Filter departureCountryFilter = session.enableFilter("departureCountryFilter");
			departureCountryFilter.setParameter("departureCountryParam", parameters.get("departure_country"));
		}
		if (parameters.containsKey("destination_country")) {
			Filter destinationCountryFilter = session.enableFilter("destinationCountryFilter");
			destinationCountryFilter.setParameter("destinationCountryParam", parameters.get("destination_country"));
		}
		if (parameters.containsKey("start_date")) {
			Filter startDateFilter = session.enableFilter("startDateFilter");
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = null;
			try {
				date = format.parse(parameters.get("start_date"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			startDateFilter.setParameter("startDateParam", date);
		}
		if (parameters.containsKey("end_date")) {
			Filter endDateFilter = session.enableFilter("endDateFilter");
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = null;
			try {
				date = format.parse(parameters.get("end_date"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			endDateFilter.setParameter("endDateParam", date);
		}
		if (parameters.containsKey("nutrition")) {
			Filter nutritionFilter = session.enableFilter("nutritionFilter");
			nutritionFilter.setParameter("nutritionParam", parameters.get("nutrition"));
		}
		if (parameters.containsKey("category")) {
			Filter categoryFilter = session.enableFilter("categoryFilter");
			categoryFilter.setParameter("categoryParam", parameters.get("category"));
		}
		if (parameters.containsKey("minday")) {
			Filter mindayFilter = session.enableFilter("mindayFilter");
			mindayFilter.setParameter("mindayParam", Integer.parseInt(parameters.get("minday")));
		}
		if (parameters.containsKey("maxday")) {
			Filter maxdayFilter = session.enableFilter("maxdayFilter");
			maxdayFilter.setParameter("maxdayParam", Integer.parseInt(parameters.get("maxday")));
		}
		return filters;
	}

	private void disableFilters(Set<Filter> filters, Session session) {
		filters.forEach(x -> session.disableFilter(x.getName()));
	}

}
