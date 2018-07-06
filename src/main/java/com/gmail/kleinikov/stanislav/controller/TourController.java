package com.gmail.kleinikov.stanislav.controller;

import static com.gmail.kleinikov.stanislav.util.ConstantValue.PAGE_LIST_TOUR;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.PAGE_TOUR;

import org.springframework.beans.factory.annotation.Autowired;
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
	@RequestMapping(value = { "/{country}/{type}", "/{country}" })
	public String fetchTours() {
		return PAGE_LIST_TOUR;
	}
}
