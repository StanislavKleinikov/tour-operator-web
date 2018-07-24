<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-inverse navbar-fixed-top">
	      	<div class="container">
	        	<div class="navbar-header">
	          		<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
	            		<span class="sr-only">Navigation</span>
	            		<span class="icon-bar"></span>
	            		<span class="icon-bar"></span>
	            		<span class="icon-bar"></span>
	          		</button>
	          		<a class="navbar-brand" href="home">myTourOperator</a>
	        	</div>
	        	<div id="navbar" class="navbar-collapse collapse">
	        		<c:choose>
		        		<c:when test="${pageContext.request.userPrincipal.name != null}">
	        				<form id="logoutForm" method="POST" action="logout">
	            				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	        				</form>
							<div class="pull-right">
		        				<h2 style="font-style: italic;color: #9d9d9d;">Welcome ${pageContext.request.userPrincipal.name} | <a type="button" class="btn btn-success" onclick="document.forms['logoutForm'].submit()">Logout</a>
		        				</h2>  
	        			  	</div>	
	    				</c:when>
	    				<c:otherwise>
	    					<div class="pull-right">
		        				<a type="button" class="btn btn-success" href="login">Sign in</a>
			            		<a type="button" class="btn btn-success" href="registration">Registration</a> 
			            	</div>	
	        			</c:otherwise>  
	            	</c:choose>	
	        	</div><!--/.navbar-collapse -->
	      	</div>
	    </nav>