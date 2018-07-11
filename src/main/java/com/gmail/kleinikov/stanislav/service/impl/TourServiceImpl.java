package com.gmail.kleinikov.stanislav.service.impl;

import java.util.List;
import java.util.stream.Collectors;

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
		List<Tour> list = tourDao.fetchAll();
		return list;
	}

	@Override
	@Transactional
	public Tour fetchTour(long id) {
		return tourDao.fetchTour(id);
	}

	@Override
	@Transactional
	public List<Tour> fetchAllByCountry(String country) {
		List<Tour> list = fetchAll();
		list = list.stream().filter(x -> country.equalsIgnoreCase(x.getCountry().getName()))
				.collect(Collectors.toList());
		return list;
	}

	@Override
	@Transactional
	public List<Tour> fetchHot() {
		List<Tour> tours = tourDao.fetchAll();
		tours = tours.stream().filter(x -> "hot".equalsIgnoreCase(x.getStatus().getName()))
				.collect(Collectors.toList());
		return tours;
	}

}
