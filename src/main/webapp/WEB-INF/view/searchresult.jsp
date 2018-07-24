<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
	<head>
    	<spring:url value="/tour/search/list" var="pageurl" />
    	<spring:url value="/resources" var="resources" />
    	<jsp:include page="/WEB-INF/view/component/header.jsp"></jsp:include>	
    </head>
	<body>
		<jsp:include page="/WEB-INF/view/component/navbar.jsp"></jsp:include>	
		<div class="container">
      		<div class="row row-offcanvas row-offcanvas-right">
       			<div class="col-xs-12 col-sm-9">
          			<p class="pull-right visible-xs">
           		   		<button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas" data-target="#sidebar">Toggle nav</button>
          			</p>
          				
          							       
				    <div>
				        <c:set var="pageHolder" value="${searchTourHolder}" scope="session" />
				        <div class="row page" id="tours">          			
	          			<c:forEach var="tour"  items="${pageHolder.pageList}">
	          				<div class="col-xs-12 col-md-6 col-lg-6 post">
	          					<a href="tour/${tour.id}">	          					
		          					<img alt="img" class="img-thumbnail img-responsive img-wrap" src="resources/img/resort/${tour.resort.resortDetail.getPic()}" width="100%" height="200">
		              				<h2>${tour.hotel.getName()}</h2>		              					            			
	            				</a>
	            			</div><!--/.col-xs-12.col-lg-12-->	          			
	          			</c:forEach>            		
	          		</div><!--/row-->
				    </div>
				    <div>
				    <span style="float:left;">
				    <c:choose>
				        <c:when test="${pageHolder.firstPage}">Prev</c:when>
				        <c:otherwise><a href="prev">Prev</a></c:otherwise>
				    </c:choose>
				    </span>
				    <span>
				    <c:forEach begin="0" end="${pageHolder.pageCount-1}" varStatus="loop">
				    &nbsp;&nbsp;
				    <c:choose>
				        <c:when test="${loop.index == pageHolder.page}">${loop.index+1}</c:when>
				        <c:otherwise><a href="${loop.index}">${loop.index+1}</a></c:otherwise>
				    </c:choose>
				    &nbsp;&nbsp;
				    </c:forEach>
				    </span>
				    <span>
				    <c:choose>
				        <c:when test="${pageHolder.lastPage}">Next</c:when>
				        <c:otherwise><a href="next">Next</a></c:otherwise>
				    </c:choose>
				    </span>
				    </div>

       			</div><!--/.col-xs-12.col-sm-9-->

		       <jsp:include page="/WEB-INF/view/component/navigator.jsp"></jsp:include>
		       <jsp:include page="/WEB-INF/view/component/searchtourpanel.jsp"></jsp:include>					
			</div><!--/row-->
		</div>
		<jsp:include page="/WEB-INF/view/component/footer.jsp"></jsp:include>
	</body>
</html>