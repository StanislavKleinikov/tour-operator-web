package com.gmail.kleinikov.stanislav.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gmail.kleinikov.stanislav.dao.TourDao;
import com.gmail.kleinikov.stanislav.entity.Tour;
import com.gmail.kleinikov.stanislav.service.TourService;

@Service
public class TourServiceImpl implements TourService {

	@Autowired
	private TourDao tourDao;

	@Override
	@Transactional
	public List<Tour> fetchAll() {
		// TODO Auto-generated method stub
		return tourDao.fetchAll();
	}

	@Override
	@Transactional
	public Tour fetchTour(long id) {
		// TODO Auto-generated method stub
		return tourDao.fetchTour();
	}

	@Override
	@Transactional
	public List<Tour> fetchAllByCountry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Tour> fetchHot() {
		// TODO Auto-generated method stub
		return null;
	}

}
