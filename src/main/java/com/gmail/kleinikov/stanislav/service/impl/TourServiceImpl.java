package com.gmail.kleinikov.stanislav.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gmail.kleinikov.stanislav.dao.TourDao;
import com.gmail.kleinikov.stanislav.entity.Country;
import com.gmail.kleinikov.stanislav.entity.Status;
import com.gmail.kleinikov.stanislav.entity.Tour;
import com.gmail.kleinikov.stanislav.service.NewsService;
import com.gmail.kleinikov.stanislav.service.TourService;

/**
 * Implementation of {@link NewsService} interface.
 *
 * @author Kleinikov Stanislav
 * @version 1.0
 */
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

	/**
	 * The method designed to filter the List of all {@link Tour} and to return the
	 * List of {@link Tour} depending on {@link Country}.
	 *
	 * @param country
	 *            - name of Country
	 * @see Country
	 * @see Collectors
	 */
	@Override
	@Transactional
	public List<Tour> fetchAllByCountry(String country) {
		List<Tour> list = fetchAll();
		list = list.stream().filter(x -> country.equalsIgnoreCase(x.getCountry().getName()))
				.collect(Collectors.toList());
		return list;
	}

	/**
	 * The method designed to filter the List of all {@link Tour} and to return the
	 * List of {@link Tour} which contains only Tours with 'hot' {@link Status}.
	 *
	 * @see Status
	 * @see TourDao
	 * @see Status
	 * @see Collectors
	 */
	@Override
	@Transactional
	public List<Tour> fetchHot() {
		List<Tour> tours = tourDao.fetchAll();
		tours = tours.stream().filter(x -> "hot".equalsIgnoreCase(x.getStatus().getName()))
				.collect(Collectors.toList());
		return tours;
	}

	/**
	 * The method invokes searchTour method of {@link TourDao}
	 *
	 * @param parameters
	 *            - Map that contains different parameters as conditions for search
	 *            {@link Tour}
	 * @See Map
	 * @See TourDao
	 */
	@Override
	@Transactional
	public List<Tour> searchTour(Map<String, String> parameters) {
		List<Tour> tours = tourDao.searchTour(parameters);
		return tours;
	}

	@Override
	public void createTour(Tour tour) {
		tourDao.createTour(tour);
	}

	@Override
	public void deleteTour(long id) {
		tourDao.deleteTour(id);
	}

	@Override
	public void updateTour(long id) {
		tourDao.updateTour(id);
	}

}
