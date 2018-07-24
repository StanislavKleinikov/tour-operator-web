package com.gmail.kleinikov.stanislav.service;

import java.util.List;
import java.util.Map;

import com.gmail.kleinikov.stanislav.entity.Tour;

/**
 * Service class for {@link com.gmail.kleinikov.stanislav.entity.Tour}
 *
 * @author Stanislav Kleinikov
 * @version 1.0
 */

public interface TourService {

	List<Tour> fetchAll();

	List<Tour> fetchAllByCountry(String country);

	List<Tour> fetchHot();

	List<Tour> searchTour(Map<String, String> parameters);

	Tour fetchTour(long id);

	void createTour(Tour tour);

	void deleteTour(long id);

	void updateTour(long id);

}
