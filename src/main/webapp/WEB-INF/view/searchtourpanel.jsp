<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	<div class="col-xs-12 col-sm-3">
		<form action="#"  class="alert alert-success">
			<h4 class="alert-heading">Подобрать тур</h4>
			<div class="form-group">
				<label for="fromcountry">Откуда</label>
				<select id="fromcountry" class="form-control">	
					<option>Москва</option>
					<option>Минск</option>
					<option>Киев</option>
				</select>
			</div>
			<div class="form-group">
				<label for="tocountry">Куда</label>
				<select id="tocountry" class="form-control">
					<option>Турция</option>
					<option>Египет</option>
					<option>Греция</option>
					<option>Вьетнам</option>
					<option>Китай</option>
				</select>			
			</div>
			<div class="form-group">
				<label for="mindate">C</label>
				<input type="date" id="mindate" class="form-control"></input>			
			</div>
			<div class="form-group">
				<label for="maxdate">По</label>
				<input type="date" id="maxdate" class="form-control"></input>	
			</div>	
			<div class="form-group">
				<label for="minday">Ночей от</label>
				<input type="number" min="1" id="minday" class="form-control"></input>
			</div>
			<div class="form-group">
				<label for="maxday">По</label>
				<input type="number" min="1" id="maxday" class="form-control"></input>		
			</div>
			<button class="btn btn-success" type="submit">Подобрать</button>	
		</form>	
	</div>
	
	
	
	
	