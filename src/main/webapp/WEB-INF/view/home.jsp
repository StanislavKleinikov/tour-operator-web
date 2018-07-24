<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
    	<jsp:include page="/WEB-INF/view/component/header.jsp"></jsp:include>	
    </head>
	<body>
		<jsp:include page="/WEB-INF/view/component/navbar.jsp"></jsp:include>	
		<div class="container">
      		<div class="row row-offcanvas row-offcanvas-right">
       			<div class="col-xs-12 col-sm-9">
          			<p class="pull-right visible-xs">
           		   		<button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas" data-target="#sidebar">Navigation</button>
          			</p>
          			<div class="jumbotron">
            			<h1>Hello, User</h1>
           				<p>Welcome</p> 
           			</div>				       
				    <div class="row page" id="news">          			
	          			<c:forEach var="news" begin="0" end="2" items="${news}">
	          				<div class="col-xs-12 col-lg-4 post">
	          					<img alt="img" src="resources/img/news/${news.getPic()}" width="100%" height="200px">
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
	          			<c:forEach var="tour" begin="0" end="5" items="${tours}">
	          				<div class="col-xs-12 col-md-6 col-lg-6 post"> 	          				      					
	          					<div class="img-thumbnail" >
	          						<a href="tour/${tour.id}">						        					
			          					<img alt="img"  src="resources/img/resort/${tour.resort.resortDetail.getPic()}" height="300px" width="100%">	          						
			          					<div>
			          						<span>за человека</span>		          					
			          				   </div>
			          				</a> 		          				   				
		          				</div>		          							          					          						     		          				         					            				            				
	            			</div><!--/.col-xs-12.col-lg-12-->	          			
	          			</c:forEach>            		
	          		</div><!--/row-->   		
       			</div><!--/.col-xs-12.col-sm-9-->
	       		<jsp:include page="/WEB-INF/view/component/navigator.jsp"></jsp:include>
	       		<jsp:include page="/WEB-INF/view/component/searchtourpanel.jsp"></jsp:include>
			</div><!--/row-->
		</div>
		<jsp:include page="/WEB-INF/view/component/footer.jsp"></jsp:include>
	</body>
</html>
