<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<jsp:include page="/WEB-INF/view/component/header.jsp"></jsp:include>	
	<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/admin-page.css"/>" />
	<title>Admin</title>
</head>
<body>
	<jsp:include page="/WEB-INF/view/component/navbar.jsp"></jsp:include>
	
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div id="wrapper">
					<div id="header">
						<h1>Site Manager</h1>
					</div>
				</div>
				<c:if test="${message != null}">
					<script type="text/javascript">
						alert('${message}');
					</script>
				</c:if>
				<c:if test="${pageContext.request.userPrincipal.name != null}">
			        <form id="logoutForm" method="post" action="${pageContext.request.contextPath}/logout">
			            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			        </form>
			        <div id="wrapper">
						<div id="header">
			        		<h2>Admin Page ${pageContext.request.userPrincipal.name} | <a type="button" class="btn btn-warning" onclick="document.forms['logoutForm'].submit()">Logout</a></h2>
			        	</div>
			        </div>		      
			    </c:if>
			    
				<div class="form-group">
					<a type="button" onclick="editNews()"  class="form-control btn btn-success" >Edit News</a>
					<!-- <a type="button" onclick="editUsers()" class="form-control btn btn-success" >Edit Users</a>
					<a type="button" onclick="editTours()" class="form-control btn btn-success" >Edit Tours</a> -->
				</div>
				
				<div class="content">
						Select an action
				</div>
		
			</div>
		</div>
	</div>     
	<script type="text/javascript">
        function editNews() {
            $.ajax({
                type: "GET",
                url: "admin/news/list",         
                data: {"${_csrf.parameterName}":"${_csrf.token}"},           
                success: function (data) {
                    $(".content").html(data);
                }
            });
        }
        
        function testAjax() {
    		 $.ajax({
                type: "GET",
                url: "admin/editUsers",         
                data: {"${_csrf.parameterName}":"${_csrf.token}"},           
                success: function (data) {
                    $(".content").html(data);
                }
            });
		}
		
		function editTours() {
			$.ajax({
                type: "GET",
                url: "admin/editTours",          
                data: {"${_csrf.parameterName}":"${_csrf.token}"},
                success: function (data) {
                    $(".content").html(data);
                }
            });
		}
		
	</script>
	<jsp:include page="/WEB-INF/view/component/footer.jsp"></jsp:include>	
</body>
</html>