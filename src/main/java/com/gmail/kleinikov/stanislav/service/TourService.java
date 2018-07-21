package com.gmail.kleinikov.stanislav.service;

import java.util.List;
import java.util.Map;

import com.gmail.kleinikov.stanislav.entity.Tour;

public interface TourService {

	List<Tour> fetchAll();

	List<Tour> fetchAllByCountry(String country);

	List<Tour> fetchHot();

	List<Tour> searchTour(Map<String, String> parameters);

	Tour fetchTour(long id);

	Tour createTour(Tour tour);

	Tour deleteTour(long id);

	Tour updateTour(long id);

}
