<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<div>
	<input type="button" value="Add News"
		onclick="showFormNews()" class="add-button" />
	<table>
		<tr>
			<th>Id</th>
			<th>Topic</th>
			<th>Date</th>
			<th>Status</th>
			<th>Picture</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${newsList}" var="news">	
			<c:url var="deleteLink" value="/admin/deleteNews">
				<c:param name="newsId" value="${news.id}"/>
			</c:url>
			<tr>
				<td>${news.id}</td>
				<td>${news.topic}</td>
				<td>${news.date.getTime()}</td>
				<td>${news.status.name}</td>
				<td>${news.pic}</td>
				<td>			
					<a id="${news.id}" type ="button" class="btn btn-success"  onclick="showFormNews('${news.id}');">Update</a>
					<a type ="button" class="btn btn-danger" href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
				</td>
			</tr>
			
		</c:forEach>
	</table>
</div>
<script type="text/javascript" >
function showFormNews(id){
	$.ajax({
		 type: "GET",
		 url: "admin/showFormNews",         
		 data: {"${_csrf.parameterName}":"${_csrf.token}" ,
		  "newsId": id},
		 success: function (data) {
		 	$(".content").html(data);
		 }
	});	
}
</script>
