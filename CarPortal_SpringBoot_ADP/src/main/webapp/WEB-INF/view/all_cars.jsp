<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="/style/style.css" rel="stylesheet" />
<title>ALL CARS</title>
</head>
<body>
<%@ include file="header.jsp"%>
<main class="container">
<h2 class="text-center">Car List</h2>

	<c:if test="${not empty listcars}">
	<div class="table-responsive-lg">
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>No.</th>
					<th>Car ID </th>
					<th>Seller</th>
					<th>Model</th>
					<th>Brand</th>
					<th>Year</th>
					<th>Price</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<% int i=1; %>
				<c:forEach var="car" items="${listcars}">
				<tr>
					<td><%=i %></td>
					<td>${car.id}</td>
					<td>${car.user.name}</td>
					<td>${car.model}</td>
					<td>${car.brand}</td>
					<td>${car.makeYear}</td>
					<td>$ ${car.amount}</td>
					<td>
						<!-- <div class="btn-group">
		                  <button type="button" class="btn btn-link btn-rounded btn-sm fw-bold">View</button>
		                  <button type="button" class="btn btn-link btn-rounded btn-sm fw-bold">Edit</button>
		                  <button type="button" class="btn btn-link btn-rounded btn-sm fw-bold">Delete</button>
		                  <button type="button" class="btn btn-link btn-rounded btn-sm fw-bold">Promote</button>
		                </div> -->
		                <div class="dropdown">
						  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
						    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-three-dots-vertical" viewBox="0 0 16 16">
							  <path d="M9.5 13a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0z"/>
							</svg>
						  </button>
						  <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
						    <li><a class="dropdown-item" href="car_detail?id=${car.id}">View</a></li>
						    <li><a class="dropdown-item" href="edit_car?id=${car.id}">Edit</a></li>
						    <li><a class="dropdown-item" href="activate_car?id=${car.id}">Activate</a></li>
						    <li><a class="dropdown-item" href="deactivate_car?id=${car.id}">Deactivate</a></li>
						    <li><a class="dropdown-item" href="delete_car?id=${car.id}">Delete</a></li>
						  </ul>
						</div>
					</td>
				</tr>
				<% i++; %>
				</c:forEach>
			</tbody>
		</table>
	</div>
	</c:if>
	
	
</main>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
</body>
</html>