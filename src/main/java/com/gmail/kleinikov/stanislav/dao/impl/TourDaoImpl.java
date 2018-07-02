package com.gmail.kleinikov.stanislav.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.gmail.kleinikov.stanislav.entity.Tour;
import com.gmail.kleinikov.stanislav.dao.TourDao;

public class TourDaoImpl implements TourDao {



	public TourDaoImpl() {
		
	}

	@Override
	public List<Tour> fetchAll() {
		// TODO Auto-generated method stub
		return new ArrayList<Tour>();
	}

	@Override
	public Tour fetchTour() {
		// TODO Auto-generated method stub
		return new Tour();
	}

}
