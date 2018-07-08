package com.gmail.kleinikov.stanislav.dao;

import java.util.List;

import com.gmail.kleinikov.stanislav.entity.Tour;

public interface TourDao {

	List<Tour> fetchAll();

	Tour fetchTour(long id);

}
