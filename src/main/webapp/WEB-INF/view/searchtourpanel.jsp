<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	<div class="col-xs-12 col-sm-3 pull-right">
		<form action="tour/search/list"  method="post" class="alert alert-success">
			<h4 class="alert-heading">Подобрать тур</h4>
			<div class="form-group">
				<label for="departureCountryParam">Откуда</label>
				<select id="departureCountryParam" name="departureCountryParam" class="form-control">
					<option value="">Не указано</option>	
					<option >Москва</option>
					<option>Минск</option>
					<option>Киев</option>
				</select>
			</div>
			<div class="form-group">
				<label for="destinationCountryParam">Куда</label>
				<select id="destinationCountryParam" name="destinationCountryParam"class="form-control">
					<option value="">Не указано</option>
					<option>Турция</option>
					<option>Египет</option>
					<option>Греция</option>
					<option>Вьетнам</option>
					<option>Китай</option>
				</select>			
			</div>
			<div class="form-group">
				<label for="startDateParam">C</label>
				<input type="date" id="startDateParam" pattern="yyyy-MM-dd" name="startDateParam" class="form-control"></input>			
			</div>
			<div class="form-group">
				<label for="endDateParam">По</label>
				<input type="date" id="endDateParam" pattern="yyyy-MM-dd" name="endDateParam" class="form-control"></input>	
			</div>	
			<div class="form-group">
				<label for="categoryParam" data-toggle="tooltip" data-placement="top" title="category">Тип</label>
				<select id="categoryParam" name="categoryParam" class="form-control">
					<option value="">Любой</option>
					<option value="2">2*</option>
					<option value="3">3*</option>
					<option value="4">4*</option>
					<option value="5">5*</option>
					<option>Apts</option>
					<option>Villas</option>
					<option>HV-1</option>
					<option>HV-2</option>
				</select>
				<label for="nutritionParam">Питание</label>
				<select id="nutritionParam" name="nutritionParam" class="form-control">
					<option value="">Любое</option>
					<option>Al</option>
					<option>BB</option>
					<option>FB</option>
					<option>FB+</option>
					<option>HB</option>
					<option>HB+</option>
					<option>RO</option>
					<option>UAl</option>
				</select>			
			</div>
			<div class="form-group">
				<label for="mindayParam">Ночей от</label>
				<input type="number"  min="1" id="mindayParam" name="mindayParam" class="form-control"></input>
			</div>
			<div class="form-group">
				<label for="maxdayParam">По</label>
				<input type="number" min="1" id="maxdayParam" name="maxdayParam" class="form-control"></input>		
			</div>
			<button class="btn btn-success" type="submit">Подобрать</button>	
		</form>	
	</div>
	
	
	
	
	