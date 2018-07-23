package com.gmail.kleinikov.stanislav.controller;

import static com.gmail.kleinikov.stanislav.util.ConstantValue.PAGE_ADMIN;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.PAGE_ADMIN_FORM_NEWS;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.PAGE_ADMIN_LIST_NEWS;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.PAGE_ADMIN_LIST_TOUR;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.PAGE_ADMIN_LIST_USER;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.STATUS_ACTIVE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gmail.kleinikov.stanislav.entity.News;
import com.gmail.kleinikov.stanislav.entity.Status;
import com.gmail.kleinikov.stanislav.entity.Tour;
import com.gmail.kleinikov.stanislav.entity.User;
import com.gmail.kleinikov.stanislav.service.NewsService;
import com.gmail.kleinikov.stanislav.service.TourService;
import com.gmail.kleinikov.stanislav.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private NewsService newsService;

	@Autowired
	private UserService userService;

	@Autowired
	private TourService tourService;

	@GetMapping("/news/list")
	public String getNews(Model model) {
		List<News> news = newsService.getAllNews();
		model.addAttribute("newsList", news);
		return PAGE_ADMIN_LIST_NEWS;
	}

	@GetMapping("/editUsers")
	public String getUsers(Model model) {
		List<User> users = userService.fetchAll();
		model.addAttribute("userList", users);
		return PAGE_ADMIN_LIST_USER;
	}

	@GetMapping("/editTours")
	public String editTours(Model model) {
		List<Tour> tours = tourService.fetchAll();
		model.addAttribute("tourList", tours);
		return PAGE_ADMIN_LIST_TOUR;
	}

	@GetMapping("/showFormNews")
	public String formNews(@RequestParam(name = "newsId", required = false) Long id, Model model) {
		if (null != id) {
			News news = newsService.getNews(id);
			model.addAttribute("newsForm", news);
		} else {
			News news = new News();
			news.setStatus(new Status(STATUS_ACTIVE));
			model.addAttribute("newsForm", news);
		}
		return PAGE_ADMIN_FORM_NEWS;
	}

	@PostMapping("/saveNews")
	public String saveNews(@ModelAttribute("newsForm") News newsForm, BindingResult bindingResult, Model model,
			RedirectAttributes attributes) {
		if (bindingResult.hasErrors()) {
			return PAGE_ADMIN_FORM_NEWS;
		}
		newsService.saveNews(newsForm);
		attributes.addFlashAttribute("message", "The news has been saved");
		return "redirect:/" + PAGE_ADMIN;
	}

	@GetMapping("/deleteNews")
	public String deleteCustomer(@RequestParam("newsId") long id, Model model, RedirectAttributes attributes) {
		newsService.deleteNews(id);
		attributes.addFlashAttribute("message", "The news has been deleted");
		return "redirect:/" + PAGE_ADMIN;
	}
}
