package com.gmail.kleinikov.stanislav.controller;

import static com.gmail.kleinikov.stanislav.util.ConstantValue.PAGE_LIST_TOUR;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.PAGE_TOUR;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.TOUR_PER_PAGE;

import java.util.List;
import java.util.Map;

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
public class TourController {

	@Autowired
	private TourService tourService;

	@GetMapping
	@RequestMapping("/tour/{id}")
	public String fetchTour(@PathVariable("id") long id, Model model) {
		Tour tour = tourService.fetchTour(id);
		model.addAttribute("tour", tour);
		return PAGE_TOUR;
	}

	@GetMapping
	@RequestMapping(value = { "/{country}/{type}", "/{country}" })
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
