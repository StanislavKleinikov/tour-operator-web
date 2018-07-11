package com.gmail.kleinikov.stanislav.dao.impl;

import java.util.List;

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

}
