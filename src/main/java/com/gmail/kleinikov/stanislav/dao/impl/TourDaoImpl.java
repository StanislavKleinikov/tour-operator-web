package com.gmail.kleinikov.stanislav.dao.impl;

import static com.gmail.kleinikov.stanislav.util.ConstantValue.FILTER_PARAM_CATEGORY;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.FILTER_PARAM_COUNTRY;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.FILTER_PARAM_DEPARTURE;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.FILTER_PARAM_ENDDATE;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.FILTER_PARAM_MAXDAY;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.FILTER_PARAM_MINDAY;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.FILTER_PARAM_NUTRITION;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.FILTER_PARAM_STARTDATE;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.FILTER_TOUR_CATEGORY;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.FILTER_TOUR_COUNTRY;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.FILTER_TOUR_DEPARTURE;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.FILTER_TOUR_ENDDATE;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.FILTER_TOUR_MAXDAY;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.FILTER_TOUR_MINDAY;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.FILTER_TOUR_NUTRITION;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.FILTER_TOUR_STARTDATE;

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
		if (parameters.containsKey(FILTER_PARAM_DEPARTURE)) {
			Filter departureCountryFilter = session.enableFilter(FILTER_TOUR_DEPARTURE);
			departureCountryFilter.setParameter(FILTER_PARAM_DEPARTURE, parameters.get(FILTER_PARAM_DEPARTURE));
		}
		if (parameters.containsKey(FILTER_PARAM_COUNTRY)) {
			Filter destinationCountryFilter = session.enableFilter(FILTER_TOUR_COUNTRY);
			destinationCountryFilter.setParameter(FILTER_PARAM_COUNTRY, parameters.get(FILTER_PARAM_COUNTRY));
		}
		if (parameters.containsKey(FILTER_PARAM_STARTDATE)) {
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = null;
			try {
				date = format.parse(parameters.get(FILTER_PARAM_STARTDATE));
				Filter startDateFilter = session.enableFilter(FILTER_TOUR_STARTDATE);
				startDateFilter.setParameter(FILTER_PARAM_STARTDATE, date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (parameters.containsKey(FILTER_PARAM_ENDDATE)) {
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = null;
			try {
				date = format.parse(parameters.get(FILTER_PARAM_ENDDATE));
				Filter endDateFilter = session.enableFilter(FILTER_TOUR_ENDDATE);
				endDateFilter.setParameter(FILTER_PARAM_ENDDATE, date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (parameters.containsKey(FILTER_PARAM_NUTRITION)) {
			Filter nutritionFilter = session.enableFilter(FILTER_TOUR_NUTRITION);
			nutritionFilter.setParameter(FILTER_PARAM_NUTRITION, parameters.get(FILTER_PARAM_NUTRITION));
		}
		if (parameters.containsKey(FILTER_PARAM_CATEGORY)) {
			Filter categoryFilter = session.enableFilter(FILTER_TOUR_CATEGORY);
			categoryFilter.setParameter(FILTER_PARAM_CATEGORY, parameters.get(FILTER_PARAM_CATEGORY));
		}
		if (parameters.containsKey(FILTER_PARAM_MINDAY)) {
			Filter mindayFilter = session.enableFilter(FILTER_TOUR_MINDAY);
			mindayFilter.setParameter(FILTER_PARAM_MINDAY, Integer.parseInt(parameters.get(FILTER_PARAM_MINDAY)));
		}
		if (parameters.containsKey(FILTER_PARAM_MAXDAY)) {
			Filter maxdayFilter = session.enableFilter(FILTER_TOUR_MAXDAY);
			maxdayFilter.setParameter(FILTER_PARAM_MAXDAY, Integer.parseInt(parameters.get(FILTER_PARAM_MAXDAY)));
		}
		return filters;
	}

	private void disableFilters(Set<Filter> filters, Session session) {
		filters.forEach(x -> session.disableFilter(x.getName()));
	}

	@Override
	public Tour createTour(Tour tour) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tour deleteTour(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tour updateTour(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
