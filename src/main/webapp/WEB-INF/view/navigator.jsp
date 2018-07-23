<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="security"
  uri="http://www.springframework.org/security/tags" %>
<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
	<div class="list-group">
		<a class="list-group-item active"></a>
		<security:authorize access="hasRole('ADMIN')">
			<a href="admin" class="list-group-item active">Управление сайтом</a>
		</security:authorize> 
		<a href="home" class="list-group-item">Главная</a>
		<a href="promotion/list" class="list-group-item">Акции</a>
		<a href="news/list" class="list-group-item">Новости</a>
		<a href="tour/Китай/list" class="list-group-item">Туры в Китай</a> 
		<a href="tour/Греция/list" class="list-group-item">Туры в Грецию</a> 
		<a href="tour/Вьетнам/list" class="list-group-item">Туры во Вьетнам</a> 
		<a href="tour/Египет/list" class="list-group-item">Туры в Египет</a> 
		<a href="tour/Турция/list" class="list-group-item">Туры в Турцию</a> 
		<a href="info/contact" class="list-group-item">Контакты</a>
		<a href="info/about" class="list-group-item">О компании</a>
		
	</div>
</div><!--/.sidebar-offcanvas-->
				