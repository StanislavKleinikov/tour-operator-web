<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!doctype html>
<html lang="en">
<head>
	<title>Login Page</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<jsp:include page="/WEB-INF/view/component/header.jsp"></jsp:include>	
	 <link href='<c:url value="/resources/css/registrationform.css" />' rel="stylesheet">
</head>
<body>
	<jsp:include page="/WEB-INF/view/component/navbar.jsp"></jsp:include>	
	<div class="container">
      	<div class="row row-offcanvas row-offcanvas-right">
       		<div class="col-xs-12 col-sm-9">
       			<div class="signup-form">
				    <form method="POST" action="login" class="form-signin">
				        <h2 class="form-heading">Log in</h2>
				
				        <div class="form-group ${error != null ? 'has-error' : ''}">
				            <span>${message}</span>
				            <input name="username" type="text" class="form-control"  placeholder="Username"
				                   autofocus="true"/>
				            <input name="password" type="password" class="form-control" placeholder="Password"/>
				            <span>${error}</span>
				            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				
				            <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
				            <h4 class="text-center"><a href="registration">Create an account</a></h4>
				        </div>
				    </form>
				</div>
			</div>
			<jsp:include page="/WEB-INF/view/component/navigator.jsp"></jsp:include>
		</div>
	</div>
	<jsp:include page="/WEB-INF/view/component/footer.jsp"></jsp:include>
</body>
</html>