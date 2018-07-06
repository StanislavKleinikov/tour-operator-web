<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
	<head>
    	<spring:url value="/tour" var="pageurl" />
    	<spring:url value="/resources" var="resources" />
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
          				
          							       
				    <div>
				        <c:set var="pageHolder" value="${tourHolder}" scope="session" />
				        <div class="row page" id="news">          			
	          			<c:forEach var="news"  items="${pageHolder.pageList}">
	          				<div class="col-xs-12 col-lg-12 post">
	          					<img alt="img" src="${resources}/img/${tour.getPic()}" width="100%" height="200px">
	              				<h2>${tour.getTopic()}</h2>
	              				<p>${tour.getText()}</p>
	              				<p>${tour.getDate().getTime().toLocaleString()}</p>
	              				<p><c:forEach var="tag" items="${tour.getTags()}"><c:out value="#${tag.getName()}"/></c:forEach></p>
	              				<p><a class="btn btn-default" href="${pageurl}/${tour.id}" role="button">Подробнее &raquo;</a></p>
	            			</div><!--/.col-xs-12.col-lg-12-->	          			
	          			</c:forEach>            		
	          		</div><!--/row-->
				    </div>
				    <div>
				    <span style="float:left;">
				    <c:choose>
				        <c:when test="${pageHolder.firstPage}">Prev</c:when>
				        <c:otherwise><a href="${pageurl}/list/prev">Prev</a></c:otherwise>
				    </c:choose>
				    </span>
				    <span>
				    <c:forEach begin="0" end="${pageHolder.pageCount-1}" varStatus="loop">
				    &nbsp;&nbsp;
				    <c:choose>
				        <c:when test="${loop.index == pageHolder.page}">${loop.index+1}</c:when>
				        <c:otherwise><a href="${pageurl}/list/${loop.index}">${loop.index+1}</a></c:otherwise>
				    </c:choose>
				    &nbsp;&nbsp;
				    </c:forEach>
				    </span>
				    <span>
				    <c:choose>
				        <c:when test="${pageHolder.lastPage}">Next</c:when>
				        <c:otherwise><a href="${pageurl}/list/next">Next</a></c:otherwise>
				    </c:choose>
				    </span>
				    </div>
    
    
    
    
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