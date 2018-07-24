<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
		<h3>Save News</h3>
	
		<form:form action="admin/saveNews" modelAttribute="newsForm" method="POST">

			<%-- <form:hidden path="id" /> --%>
					
			<table>
				<tbody>
					<tr>
						<td><label>Topic</label></td>
						<td>
							<spring:bind path="topic">
					            <div class="form-group ${status.error ? 'has-error' : ''}">
									<form:input path="topic" />
									<form:errors cssStyle="error" path="topic"></form:errors>
								</div>
							</spring:bind>
						</td>	
					</tr>
				
					<tr>
						<td><label>Status</label></td>
						<td>
							<spring:bind path="status.id">
					            <div class="form-group ${status.error ? 'has-error' : ''}">
									<form:select path="status.id">
										<form:option value="1">active</form:option>
										<form:option value="2">blocked</form:option>
										<form:option value="3">deleted</form:option>
									</form:select>
									<form:errors path="status.id" cssClass="error"></form:errors>
								</div>
							</spring:bind>
						</td>
					</tr>
					<tr>
						<td><label>picture</label></td>
						<td>
							<spring:bind path="pic">
					            <div class="form-group ${status.error ? 'has-error' : ''}">
									<form:input path="pic" />
									<form:errors path="pic" cssClass="error"></form:errors>
								</div>
							</spring:bind>
						</td>
					</tr>
					
					<tr>
						<td><label>Text</label></td>
						<td>
							<spring:bind path="topic">
					            <div class="form-group ${status.error ? 'has-error' : ''}">
									<form:textarea path="text" rows="15" cols="100" cssClass="text"/>
									<form:errors path="text" cssClass="error"></form:errors>
								</div>
							</spring:bind>
						</td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="save" class="save"/></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a onclick="editNews();">Back to List</a>
		</p>
	