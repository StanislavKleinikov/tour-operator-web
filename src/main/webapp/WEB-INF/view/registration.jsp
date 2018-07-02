<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib  uri="http://www.springframework.org/tags" prefix="bind"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<jsp:include page="/WEB-INF/view/header.jsp"></jsp:include>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Registration</title>	
		<link href='<c:url value="/resources/css/registrationform.css" />' rel="stylesheet">	
	</head>
	<body>
		<div class="signup-form">
		    <form:form action="submit" modelAttribute="user" method="POST">
				<h2>Register</h2>
				<p class="hint-text">Create your account. It's free and only takes a minute.</p>
				<div class="form-group">
		           	<form:input path="login" type="text" cssClass="form-control" maxlength="25" id="login" name="login" placeholder="Login" required="required"/>		      
		           	<form:errors path="login" cssClass="error"></form:errors>
		        </div>	 
		       <div class="form-group">
		            <form:input path="userDetail.email" type="email" cssClass="form-control" id="email"  name="email" placeholder="email" required="required"/>
		            <form:errors path="userDetail.email" cssClass="error"></form:errors>
		        </div> 
		        <div class="form-group">
					<div class="row">
						<div class="col-xs-6">
							<form:input path="userDetail.firstName" type="text" cssClass="form-control" name="first_name" placeholder="First Name"/>
							<form:errors path="userDetail.firstName" cssClass="error"></form:errors>
						</div>
						<div class="col-xs-6">
							<form:input path="userDetail.lastName" type="text" cssClass="form-control" name="last_name" placeholder="Last Name"/>
							<form:errors path="userDetail.lastName" cssClass="error"></form:errors>
						</div>						
					</div>        	
		        </div>
		         <div class="form-group">
		            <form:input path ="userDetail.phoneNumber" type="tel" cssClass="form-control" pattern="[0-9]{7,15}" id="phone_number"  name="phone_number" placeholder="375295030066"/>
		            <form:errors path="userDetail.phoneNumber" cssClass="error"></form:errors>
		        </div>
				<div class="form-group">
		            <form:input path="password" type="password" cssClass="form-control"  id="password" name="password" placeholder="Password" required="required"/>
		            <form:errors path="password" cssClass="error"></form:errors>
		        </div>
				<div class="form-group">
		            <input type="password" class="form-control" id="confirm_password" name="confirm_password" placeholder="Confirm Password" required="required">
		            <form:errors element="confirm_password" cssClass="error" cssStyle="color: red;" ></form:errors>
		        </div> 	
		            
				<div class="form-group">
		            <button id="submit" type="submit" class="btn btn-success btn-lg btn-block">Register Now</button>
		        </div>
		    </form:form>
		</div>
		
		<jsp:include page="/WEB-INF/view/footer.jsp"></jsp:include>	
	</body>
</html>