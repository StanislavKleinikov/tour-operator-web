package com.gmail.kleinikov.stanislav.util;

public class ConstantValue {

	public static final int NEWS_PER_PAGE = 5;
	public static final int NEWS_MAX_PAGE = 20;
	public static final int TOUR_PER_PAGE = 20;

	public static final String PAGE_HOME = "home";
	public static final String PAGE_LOGIN = "login";
	public static final String PAGE_REGISTRATION = "registration";
	public static final String PAGE_ERROR = "error";
	public static final String PAGE_NO_SUCH_USER = "noSuchUser";
	public static final String PAGE_LIST_NEWS = "listnews";
	public static final String PAGE_NEWS = "news";
	public static final String PAGE_TOUR = "tour";
	public static final String PAGE_LIST_TOUR = "listtour";
	public static final String PAGE_ABOUT = "about";
	public static final String PAGE_CONTACT = "contact";
	public static final String PAGE_SEARCH_RESULT = "searchresult";
	public static final String PAGE_ADMIN = "admin";
	public static final String PAGE_ADMIN_LIST_NEWS = "adminNewsList";
	public static final String PAGE_ADMIN_LIST_USER = "adminUserList";
	public static final String PAGE_ADMIN_LIST_TOUR = "adminTourList";
	public static final String PAGE_ADMIN_FORM_NEWS = "newsForm";

	public static final long ROLE_ADMIN = 1;
	public static final long ROLE_MANAGER = 2;
	public static final long ROLE_USER = 3;

	public static final long STATUS_ACTIVE = 1;
	public static final long STATUS_BLOCKED = 2;
	public static final long STATUS_DELETED = 3;

	public static final String FILTER_TOUR_DEPARTURE = "departureCountryFilter";
	public static final String FILTER_TOUR_COUNTRY = "destinationCountryFilter";
	public static final String FILTER_TOUR_STARTDATE = "startDateFilter";
	public static final String FILTER_TOUR_ENDDATE = "endDateFilter";
	public static final String FILTER_TOUR_NUTRITION = "nutritionFilter";
	public static final String FILTER_TOUR_CATEGORY = "categoryFilter";
	public static final String FILTER_TOUR_MINDAY = "mindayFilter";
	public static final String FILTER_TOUR_MAXDAY = "maxdayFilter";

	public static final String FILTER_PARAM_DEPARTURE = "departureCountryParam";
	public static final String FILTER_PARAM_COUNTRY = "destinationCountryParam";
	public static final String FILTER_PARAM_STARTDATE = "startDateParam";
	public static final String FILTER_PARAM_ENDDATE = "endDateParam";
	public static final String FILTER_PARAM_NUTRITION = "nutritionParam";
	public static final String FILTER_PARAM_CATEGORY = "categoryParam";
	public static final String FILTER_PARAM_MINDAY = "mindayParam";
	public static final String FILTER_PARAM_MAXDAY = "maxdayParam";

	public static final String FILTER_SQL_STATEMENT_DEPARTURE = "tour_detail in(select d.id from tour_data as d join departure as dep on d.departure=dep.id where dep.town=:departureCountryParam)";
	public static final String FILTER_SQL_STATEMENT_COUNTRY = "country in (select c.id from country as c where c.name = :destinationCountryParam)";
	public static final String FILTER_SQL_STATEMENT_STARTDATE = "tour_detail in (select d.id from tour_data as d where d.start_date >= :startDateParam)";
	public static final String FILTER_SQL_STATEMENT_ENDDATE = "tour_detail in (select d.id from tour_data as d where d.end_date <= :endDateParam)";
	public static final String FILTER_SQL_STATEMENT_NUTRITION = "tour_detail in(select d.id from tour_data as d join nutrition as n on d.nutrition=n.id where n.name=:nutritionParam)";
	public static final String FILTER_SQL_STATEMENT_CATEGORY = "hotel in (select h.id from hotel as h join category as c on h.category=c.id where c.name=:categoryParam)";
	public static final String FILTER_SQL_STATEMENT_MINDAY = "tour_detail in (select d.id from tour_data as d where (d.end_date - d.start_date)>=:mindayParam)";
	public static final String FILTER_SQL_STATEMENT_MAXDAY = "tour_detail in (select d.id from tour_data as d where (d.end_date - d.start_date)<=:maxdayParam)";
}