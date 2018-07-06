package com.gmail.kleinikov.stanislav.service;

import java.util.List;

import com.gmail.kleinikov.stanislav.entity.Tour;

public interface TourService {

	List<Tour> fetchAll();

	List<Tour> fetchAllByCountry();

	List<Tour> fetchHot();

	Tour fetchTour(long id);

}
