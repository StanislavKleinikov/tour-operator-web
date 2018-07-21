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
          				
          			
          		<h2>${tour.toString()}</h2>	
          		<c:forEach items="${tour.hotel.hotelDetail.pic}">
          		
          		</c:forEach>
    
    
       			</div><!--/.col-xs-12.col-sm-9-->

		       <jsp:include page="/WEB-INF/view/navigator.jsp"></jsp:include>
		       <jsp:include page="/WEB-INF/view/searchtourpanel.jsp"></jsp:include>				
			</div><!--/row-->
		</div>
		<jsp:include page="/WEB-INF/view/footer.jsp"></jsp:include>
	</body>
</html>