package com.gmail.kleinikov.stanislav.controller;

import static com.gmail.kleinikov.stanislav.util.ConstantValue.PAGE_LIST_TOUR;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.PAGE_SEARCH_RESULT;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.PAGE_TOUR;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.TOUR_PER_PAGE;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gmail.kleinikov.stanislav.entity.Tour;
import com.gmail.kleinikov.stanislav.service.TourService;

@Controller
@RequestMapping("/tour")
public class TourController {

	@Autowired
	private TourService tourService;

	@GetMapping
	@RequestMapping("/{id}")
	public String fetchTour(@PathVariable("id") long id, Model model) {
		Tour tour = tourService.fetchTour(id);
		model.addAttribute("tour", tour);
		return PAGE_TOUR;
	}

	@GetMapping
	@RequestMapping(value = { "/search/list/{type}", "/search/list" })
	public String searchTour(@PathVariable Map<String, String> pathVariablesMap, HttpServletRequest req) {
		Map<String, String[]> requestParameters = req.getParameterMap();
		Map<String, String> parameters = new HashMap<>();
		String type = pathVariablesMap.get("type");
		PagedListHolder<Tour> tourHolder = null;
		if (null == type) {
			requestParameters.forEach((x, y) -> parameters.put(x, y[0]));

			parameters.values().removeIf(Objects::isNull);
			parameters.values().removeIf(x -> x.equals(""));
			List<Tour> tours = tourService.searchTour(parameters);
			tourHolder = new PagedListHolder<Tour>();
			tourHolder.setSource(tours);
			tourHolder.setPageSize(TOUR_PER_PAGE);
			req.getSession().setAttribute("searchTourHolder", tourHolder);

		} else if ("next".equals(type)) {
			tourHolder = (PagedListHolder<Tour>) req.getSession().getAttribute("searchTourHolder");
			tourHolder.nextPage();

		} else if ("prev".equals(type)) {
			tourHolder = (PagedListHolder<Tour>) req.getSession().getAttribute("searchTourHolder");
			tourHolder.previousPage();

		} else {
			tourHolder = (PagedListHolder<Tour>) req.getSession().getAttribute("searchTourHolder");
			int pageNum = Integer.parseInt(type);
			tourHolder.setPage(pageNum);
		}
		return PAGE_SEARCH_RESULT;
	}

	@GetMapping
	@RequestMapping(value = { "/{country}/list/{type}", "/{country}/list" })
	public String fetchTours(@PathVariable Map<String, String> pathVariablesMap, HttpServletRequest req) {
		PagedListHolder<Tour> tourHolder = null;

		String country = pathVariablesMap.get("country");
		String type = pathVariablesMap.get("type");

		if (null == type) {

			List<Tour> tourList = tourService.fetchAllByCountry(country);

			tourHolder = new PagedListHolder<Tour>();
			tourHolder.setSource(tourList);
			tourHolder.setPageSize(TOUR_PER_PAGE);

			req.getSession().setAttribute("tourHolder", tourHolder);
			req.getSession().setAttribute("country", country);
		} else if ("next".equals(type)) {
			tourHolder = (PagedListHolder<Tour>) req.getSession().getAttribute("tourHolder");
			tourHolder.nextPage();
		} else if ("prev".equals(type)) {
			tourHolder = (PagedListHolder<Tour>) req.getSession().getAttribute("tourHolder");
			tourHolder.previousPage();
		} else {
			tourHolder = (PagedListHolder<Tour>) req.getSession().getAttribute("tourHolder");
			int pageNum = Integer.parseInt(type);
			tourHolder.setPage(pageNum);
		}
		return PAGE_LIST_TOUR;
	}
}
