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
<title>ALL USERS</title>
</head>
<body>
<%@ include file="header.jsp"%>
<main class="container">
<h2 class="text-center">User List</h2>

	<c:if test="${not empty listusers}">
	<div class="table-responsive-lg">
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>No.</th>
					<th>User ID </th>
					<th>Full Name</th>
					<th>User Name </th>
					<th>Email</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<% int i=1; %>
				<c:forEach var="user" items="${listusers}">
				<tr>
					<td><%=i %></td>
					<td>${user.id}</td>
					<td>${user.name}</td>
					<td>${user.userName}</td>
					<td>${user.email}</td>
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
						    <li><a class="dropdown-item" href="view_user?id=${user.id}">View</a></li>
						    <li><a class="dropdown-item" href="edit_user?id=${user.id}">Edit</a></li>
						    <li><a class="dropdown-item" href="promote_user?id=${user.id}">Promote</a></li>
						    <li><a class="dropdown-item" href="delete_user?id=${user.id}">Delete</a></li>
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