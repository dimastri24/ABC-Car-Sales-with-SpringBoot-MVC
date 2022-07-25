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
<title>SEARCH RESULT</title>
</head>
<body>
<%@ include file="header.jsp"%>

<main>
  <div class="album py-5 bg-light">
    <div class="container">
    
    <c:if test="${empty listcars }">
    <p class="display-6">${msg_result}</p>
    <p class="h5">Please try with another input</p>
    </c:if>

		<c:if test="${not empty listcars}">
		<p class="display-6">${msg_result}</p>
      <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
		<c:forEach var="car" items="${listcars}">
        <div class="col">
          <div class="card shadow-sm">
            <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>

            <div class="card-body">
              <p class="card-text">${car.model}, ${car.brand}</p>
              <p class="card-text">$ ${car.amount}</p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <a href="car_detail?id=${car.id}" class="btn btn-sm btn-outline-secondary">View</a>
                </div>
              </div>
            </div>
          </div>
        </div>

	   </c:forEach>
	   </div>
	   </c:if>
	   
    </div>
  </div>
</main>
<%-- <%@ include file="footer.jsp"%> --%>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
</body>
</html>