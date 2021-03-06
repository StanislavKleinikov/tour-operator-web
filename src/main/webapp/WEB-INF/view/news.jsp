<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
           		   		<button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas" data-target="#sidebar">Toggle nav</button>
          			</p>
          				
          			
          		<h2>${news.topic}</h2>	
          		<h2>${news.text}</h2>	
    
    
       			</div><!--/.col-xs-12.col-sm-9-->

		        <jsp:include page="/WEB-INF/view/component/navigator.jsp"></jsp:include>
		        <jsp:include page="/WEB-INF/view/component/searchtourpanel.jsp"></jsp:include>				
			</div><!--/row-->
		</div>
		<jsp:include page="/WEB-INF/view/component/footer.jsp"></jsp:include>
	</body>
</html>