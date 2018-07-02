package com.gmail.kleinikov.stanislav.service;

import java.util.List;

import com.gmail.kleinikov.stanislav.entity.Tour;

public interface TourService {
	
	List<Tour> fetchAll();
	
	Tour fetchTour();

}
