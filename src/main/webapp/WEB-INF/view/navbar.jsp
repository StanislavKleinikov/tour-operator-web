<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-inverse navbar-fixed-top">
	      	<div class="container">
	        	<div class="navbar-header">
	          		<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
	            		<span class="sr-only">Navigation</span>
	            		<span class="icon-bar"></span>
	            		<span class="icon-bar"></span>
	            		<span class="icon-bar"></span>
	          		</button>
	          		<a class="navbar-brand" href="#">myTourOperator</a>
	        	</div>
	        	<div id="navbar" class="navbar-collapse collapse">
	          		<form class="navbar-form navbar-right" action="" method="post">
	            		<div class="form-group">
	              			<input type="text" placeholder="login" class="form-control" name="login">
	            		</div>
	            		<div class="form-group">
	             	 		<input type="password" placeholder="Password" class="form-control" name="password">
	            		</div>
	            		<input type="hidden" name="action" value="login"/>
	            		<button type="submit" class="btn btn-success" >Sign in</button>
	            		<a type="button" class="btn btn-success" href="registration/form">Registration</a>
	            		
	          		</form>          		
	        	</div><!--/.navbar-collapse -->
	      	</div>
	    </nav>