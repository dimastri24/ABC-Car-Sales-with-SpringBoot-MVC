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
<title>MY PROFILE</title>
</head>
<body>
<%@ include file="header.jsp"%>

<section class="vh-100" >
  <div class="container py-5" style="background-color: #f4f5f7;">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col col-lg-8 mb-4 mb-lg-0">
        <div class="card mb-3" style="border-radius: .5rem;">
          <div class="row g-0">
            <div class="col-md-4 gradient-custom text-center text-white pb-2" style="border-top-left-radius: .5rem; border-bottom-left-radius: .5rem;">
              <img
                src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava1-bg.webp"
                alt="Avatar"
                class="img-fluid my-4"
                style="width: 80px;"
              />
              <h5>${userinfo.name}</h5>
              <a href="update_profile?id=${userinfo.id}" type="button" class="btn btn-info mb-2">Edit Profile</a>
              <i class="far fa-edit mb-5"></i>
            </div>
            <div class="col-md-8">
              <div class="card-body p-4">
                <h6>Information</h6>
                <hr class="mt-0 mb-4">
                <div class="row pt-1">
                  <div class="col-7 mb-3">
                    <h6>Email</h6>
                    <p class="text-muted">${userinfo.email}</p>
                  </div>
                  <div class="col-5 mb-3">
                    <h6>Phone</h6>
                    <p class="text-muted">${userinfo.phoneNumber}</p>
                  </div>
                </div>
                <!-- <h6>Projects</h6>
                <hr class="mt-0 mb-4"> -->
                <div class="row pt-1">
                  <div class="col-12">
                    <h6>Address</h6>
                    <p class="text-muted">${userinfo.address}</p>
                  </div>
  <!--                 <div class="col-6 mb-3">
                    <h6>Most Viewed</h6>
                    <p class="text-muted">Dolor sit amet</p>
                  </div> -->
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  
  <sec:authorize access="hasRole('Users')">
  <div class="container my-5">
  <c:if test="${empty cars}">
  <div>
  	<p class="display-6">Currently you are not selling any car</p>
  	<hr>
  </div>
  </c:if>
  
  <c:if test="${not empty cars}">
    <p class="display-6">List Car You Sale</p>
  	<hr>
	<div class="table-responsive-lg">
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>No.</th>
					<th>Model</th>
					<th>Brand</th>
					<th>Year</th>
					<th>Price</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<% int i=1; %>
				<c:forEach var="car" items="${cars}">
				<tr>
					<td><%=i %></td>
					<td>${car.model}</td>
					<td>${car.brand}</td>
					<td>${car.makeYear}</td>
					<td>$ ${car.amount}</td>
					<td>
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
  	</div>
  	</sec:authorize>
</section>
<%@ include file="footer.jsp"%>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
</body>
</html>