<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
	<head>
    	<jsp:include page="/WEB-INF/view/header.jsp"></jsp:include>	
    </head>
	<body>
		<jsp:include page="/WEB-INF/view/navbar.jsp"></jsp:include>	
		<div class="container">
      		<div class="row row-offcanvas row-offcanvas-right">
       			<div class="col-xs-12 col-sm-9">
          			<p class="pull-right visible-xs">
           		   		<button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas" data-target="#sidebar">Toggle nav</button>
          			</p>
          				
          			
          		<h2>${news.topic}</h2>	
          		<h2>${news.text}</h2>	
    
    
       			</div><!--/.col-xs-12.col-sm-9-->

		        <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
		        	<div class="list-group">
		        		<a class="list-group-item active"></a>
		            	<a href="promotion/list" class="list-group-item">Акции</a>
			            <a class="list-group-item active">Новости</a>
			            <a href="tours/list" class="list-group-item">Туры</a> 
			            <a href="services" class="list-group-item">Услуги</a>
			            <a href="contact" class="list-group-item">Контакты</a>
			            <a href="info" class="list-group-item">О компании</a>
		        	</div>
				</div><!--/.sidebar-offcanvas-->
				
			</div><!--/row-->
		</div>
		<jsp:include page="/WEB-INF/view/footer.jsp"></jsp:include>
	</body>
</html>