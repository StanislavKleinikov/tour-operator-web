package com.gmail.kleinikov.stanislav.service.impl;

import java.util.List;

import com.gmail.kleinikov.stanislav.entity.Tour;
import com.gmail.kleinikov.stanislav.dao.TourDao;
import com.gmail.kleinikov.stanislav.service.TourService;

public class TourServiceImpl implements TourService {

	private TourDao tourDao;

	public TourServiceImpl(TourDao tourDao) {
		this.tourDao = tourDao;
	}

	@Override
	public List<Tour> fetchAll() {
		// TODO Auto-generated method stub
		return tourDao.fetchAll();
	}

	@Override
	public Tour fetchTour() {
		// TODO Auto-generated method stub
		return tourDao.fetchTour();
	}

}
