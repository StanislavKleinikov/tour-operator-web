package com.gmail.kleinikov.stanislav.controller;

import static com.gmail.kleinikov.stanislav.util.ConstantValue.PAGE_EDIT_NEWS;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.PAGE_EDIT_TOURS;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.PAGE_EDIT_USERS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gmail.kleinikov.stanislav.service.NewsService;

@Controller
public class AdminController {

	@Autowired
	private NewsService newsService;

	@RequestMapping("/editNews")
	public String editNews() {
		return PAGE_EDIT_NEWS;
	}

	@RequestMapping("/editUsers")
	public String editUsers() {
		return PAGE_EDIT_USERS;
	}

	@RequestMapping("/editTours")
	public String editTours() {
		return PAGE_EDIT_TOURS;
	}
}
