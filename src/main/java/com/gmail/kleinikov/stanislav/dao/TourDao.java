package com.gmail.kleinikov.stanislav.dao;

import java.util.List;
import java.util.Map;

import com.gmail.kleinikov.stanislav.entity.Tour;

public interface TourDao {

	List<Tour> fetchAll();

	Tour fetchTour(long id);

	List<Tour> searchTour(Map<String, String> parameters);

	Tour createTour(Tour tour);

	void deleteTour(long id);

	Tour updateTour(long id);

}
