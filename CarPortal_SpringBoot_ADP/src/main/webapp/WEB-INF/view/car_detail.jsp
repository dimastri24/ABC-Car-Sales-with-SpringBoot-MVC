<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="/style/style.css" rel="stylesheet" />
<title>CAR DETAIL</title>
</head>
<body>
<%@ include file="header.jsp"%>
	<!-- <div class="container"> -->
	  <main class="container mb-5">

    <div class="row g-5">
    
      <div class="col-md-7 col-lg-8">
        <h4 class="mb-3">Car Details</h4>
		<div class="form-group row mb-1">
			<h6 class="control-label col-4">Car Model: </h6>
			<div class="col-8">${car.model}</div>
		</div>
		<div class="form-group row mb-1">
			<h6 class="control-label col-4">Car Brand:</h6>
			<label class="col-8">${car.brand}</label>
		</div>
		<div class="form-group row mb-1">
			<h6 class="control-label col-4">Production Year: </h6>
			<div class="col-8">${car.makeYear}</div>
		</div>
		<div class="form-group row mb-1">
			<h6 class="control-label col-4">Price: </h6>
			<div class="col-8">$ ${car.amount}</div>
		</div>
	<hr class="my-4">
	
	    <h4 class="mb-3">Seller</h4>
		<div class="form-group row mb-1">
			<h6 class="control-label col-4">Name: </h6>
			<div class="col-8">${user.name}</div>
		</div>
		<div class="form-group row mb-1">
			<h6 class="control-label col-4">Phone Number:</h6>
			<label class="col-8">${user.phoneNumber}</label>
		</div>
		<div class="form-group row mb-1">
			<h6 class="control-label col-4">Email Address: </h6>
			<div class="col-8">${user.email}</div>
		</div>
		
	<hr class="my-4">
		<h4 class="mb-3">Set a bid for this car</h4>
		<form action="car_detail?id=${car.id}" method="post">
		     <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<div class="col-12 mb-2">
              <!-- <label for="bidderPrice" class="form-label">Bid Price</label> -->
              <input type="text" class="form-control" id="bidderPrice" placeholder="Enter Bid Price" name="bitprice">
            </div>
            <button class="w-50 btn btn-primary btn-md mx-auto" type="submit">Post Bid</button>
		</form>
	
	</div>
	
      
      <div class="col-md-5 col-lg-4 order-md-last">
        <h4 class="d-flex justify-content-between align-items-center mb-3">
          <span class="text-primary">Bidding List</span>
          <!-- <span class="badge bg-primary rounded-pill">3</span> -->
        </h4>
        <c:if test="${empty bidinfo}">
        	<p>Sorry. Looks like no one has put their bid on this car.</p>
        </c:if>
        <ul class="list-group mb-3">
        <c:forEach var="bid" items="${bidinfo}">
          <li class="list-group-item d-flex justify-content-between lh-sm">
            <div>
              <h6 class="my-0">${bid.user.name}</h6>
              <small class="text-muted">${bid.bidDate}</small>
            </div>
            <span class="text-muted">$ ${bid.bidderPrice}</span>
          </li>
		</c:forEach>
        </ul>
      </div>
      
    </div>
  </main>
	<!-- </div> -->
    
<%@ include file="footer.jsp"%>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
</body>
</html>