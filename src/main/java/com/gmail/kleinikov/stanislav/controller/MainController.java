package com.gmail.kleinikov.stanislav.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gmail.kleinikov.stanislav.entity.News;
import com.gmail.kleinikov.stanislav.service.NewsService;

import static com.gmail.kleinikov.stanislav.util.ConstantValue.*;

@Controller
public class MainController {
	
	@Autowired
	private NewsService newsService;
	
	@RequestMapping("/home")
	public String home(Model model) {	
		
		List<News> news = newsService.getNews();
						
		model.addAttribute("news" ,news);
		
		return PAGE_HOME;
	}
	
}
