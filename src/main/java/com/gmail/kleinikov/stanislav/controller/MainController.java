package com.gmail.kleinikov.stanislav.controller;

import static com.gmail.kleinikov.stanislav.util.ConstantValue.PAGE_ABOUT;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.PAGE_CONTACT;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.PAGE_HOME;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gmail.kleinikov.stanislav.entity.News;
import com.gmail.kleinikov.stanislav.entity.Tour;
import com.gmail.kleinikov.stanislav.service.NewsService;
import com.gmail.kleinikov.stanislav.service.TourService;

@Controller
public class MainController {

	@Autowired
	private NewsService newsService;

	@Autowired
	private TourService tourService;

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String home(Model model) {

		List<News> news = newsService.getNews();

		List<Tour> tours = tourService.fetchHot();

		model.addAttribute("news", news);
		model.addAttribute("tours", tours);

		return PAGE_HOME;
	}

	@RequestMapping("/info/contact")
	public String contact(Model model) {
		return PAGE_CONTACT;
	}

	@RequestMapping("/info/about")
	public String about(Model model) {
		return PAGE_ABOUT;
	}
}
