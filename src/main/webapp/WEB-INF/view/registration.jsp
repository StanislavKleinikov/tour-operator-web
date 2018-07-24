<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Create an account</title>
    <jsp:include page="/WEB-INF/view/component/header.jsp"></jsp:include>	
    <link href='<c:url value="/resources/css/registrationform.css" />' rel="stylesheet">
</head>

<body>
	<jsp:include page="/WEB-INF/view/component/navbar.jsp"></jsp:include>	
	<div class="container">
      	<div class="row row-offcanvas row-offcanvas-right">
       		<div class="col-xs-12 col-sm-9">
       			<div class="signup-form">
				    <form:form method="POST" modelAttribute="userForm" class="form-signin">
				        <h2 class="form-signin-heading">Create your account</h2>
				        <spring:bind path="username">
				            <div class="form-group ${status.error ? 'has-error' : ''}">
				                <form:input type="text" path="username" class="form-control" placeholder="Username"
				                            autofocus="true"></form:input>
				                <form:errors path="username"></form:errors>
				            </div>
				        </spring:bind>
				
				        <spring:bind path="password">
				            <div class="form-group ${status.error ? 'has-error' : ''}">
				                <form:input type="password" path="password" class="form-control" placeholder="Password"></form:input>
				                <form:errors path="password"></form:errors>
				            </div>
				        </spring:bind>
				
				        <spring:bind path="confirmPassword">
				            <div class="form-group ${status.error ? 'has-error' : ''}">
				                <form:input type="password" path="confirmPassword" class="form-control"
				                            placeholder="Confirm your password"></form:input>
				                <form:errors path="confirmPassword"></form:errors>
				            </div>
				        </spring:bind>
				        
				        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
				    </form:form>
			    </div>
			</div>
			<jsp:include page="/WEB-INF/view/component/navigator.jsp"></jsp:include>
		</div>	
	</div>
<jsp:include page="/WEB-INF/view/component/footer.jsp"></jsp:include>
</body>
</html>