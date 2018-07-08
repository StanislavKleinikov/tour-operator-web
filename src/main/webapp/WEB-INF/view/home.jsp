<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
          			<div class="jumbotron">
            			<h1>Hello, User</h1>
           				<p>Welcome</p> 
           			</div>				       
				    <div class="row page" id="news">          			
	          			<c:forEach var="news" begin="0" end="2" items="${news}">
	          				<div class="col-xs-12 col-lg-4 post">
	          					<img alt="img" src="resources/img/news/${news.getPic()}" width="100%" height="200">
	              				<h2>${news.getTopic()}</h2>
	              				<p>${news.getPreview()}</p>
	              				<p>${news.getDate().getTime().toLocaleString()}</p>
	              				<p><c:forEach var="tag" items="${news.getTags()}"><c:out value="#${tag.getName()}"/></c:forEach></p>
	              				<p><a class="btn btn-default" href="news/${news.id}" role="button">Подробнее &raquo;</a></p>
	            			</div><!--/.col-xs-12.col-lg-12-->	          			
	          			</c:forEach>            		
	          		</div><!--/row-->
				 	
				 	<hr>
				 	
				 	 <div class="row page" id="tours">          			
	          			<c:forEach var="tour"  items="${tours}">
	          				<div class="col-xs-12 col-md-6 col-lg-4 post">
	          					<a href="tours/${tour.id}">	          					
		          					<img alt="img" class="img-thumbnail img-responsive img-wrap" src="resources/img/hotels/${tour.hotel.hotelDetail.getPic()}/1.jpg" width="100%" height="200">
		              				<h2>${tour.hotel.getName()}</h2>		              					            			
	            				</a>
	            			</div><!--/.col-xs-12.col-lg-12-->	          			
	          			</c:forEach>            		
	          		</div><!--/row-->   
	          		 			
       			</div><!--/.col-xs-12.col-sm-9-->

		        <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
		        	<div class="list-group">
		        		<a class="list-group-item active"></a>
		        		<a class="list-group-item">Главная</a>
		            	<a href="promotion/list" class="list-group-item">Акции</a>
			            <a href="news/list" class="list-group-item">Новости</a>
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
