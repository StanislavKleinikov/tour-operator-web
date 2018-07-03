package com.gmail.kleinikov.stanislav.controller;

import static com.gmail.kleinikov.stanislav.util.ConstantValue.NEWS_MAX_PAGE;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.NEWS_PER_PAGE;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.PAGE_LIST_NEWS;
import static com.gmail.kleinikov.stanislav.util.ConstantValue.PAGE_NEWS;

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

import com.gmail.kleinikov.stanislav.entity.News;
import com.gmail.kleinikov.stanislav.service.NewsService;

@Controller
@RequestMapping("/news")
public class NewsController {

	@Autowired
	private NewsService newsService;

	@GetMapping
	@RequestMapping("/{id}")
	public String news(@PathVariable("id") long id, Model model) {
		News news = newsService.getNews(id);
		model.addAttribute("news", news);
		return PAGE_NEWS;
	}

	@GetMapping
	@RequestMapping(value = { "/list/{type}", "/list" })
	public String newsList(@PathVariable Map<String, String> pathVariablesMap, HttpServletRequest req) {

		PagedListHolder<News> newsHolder = null;

		String type = pathVariablesMap.get("type");

		if (null == type) {

			List<News> newsList = newsService.getNews();

			newsHolder = new PagedListHolder<News>();
			newsHolder.setSource(newsList);
			newsHolder.setPageSize(NEWS_PER_PAGE);
			newsHolder.setMaxLinkedPages(NEWS_MAX_PAGE);

			req.getSession().setAttribute("newsHolder", newsHolder);

		} else if ("next".equals(type)) {

			newsHolder = (PagedListHolder<News>) req.getSession().getAttribute("newsHolder");

			newsHolder.nextPage();

		} else if ("prev".equals(type)) {

			newsHolder = (PagedListHolder<News>) req.getSession().getAttribute("newsHolder");

			newsHolder.previousPage();

		} else {

			newsHolder = (PagedListHolder<News>) req.getSession().getAttribute("newsHolder");

			int pageNum = Integer.parseInt(type);

			newsHolder.setPage(pageNum);

		}

		return PAGE_LIST_NEWS;
	}
}
