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
<title>EDIT CAR</title>
</head>
<body>
<%@ include file="header.jsp"%>
<div class="container">
<div class="d-flex flex-wrap align-items-center justify-content-center mx-auto pt-3 pb-5 mb-5 rounded col-md-10 col-lg-8">
      <div class="col-md-8 col-lg-10">
        <h4 class="mb-3">Edit Sale Car</h4>
        <form:form method="post" id="carform" modelAttribute="car" action="save_car">
        <input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
          <div class="row g-3">
			<form:input path="id" hidden="hidden"/>
            <div class="col-12">
              <form:label for="model" class="form-label" path="model">Model</form:label>
              <form:input type="text" class="form-control" path="model" id="model" placeholder="Ex.Avanza Velos"/>
            </div>

            <div class="col-12">
              <form:label for="brand" class="form-label" path="brand">Brand</form:label>
              <form:input type="text" class="form-control" path="brand" id="brand" placeholder="Ex. Toyota"/>
            </div>

          <hr class="my-4">
			<div class="col-12">
              <form:label for="makeYear" class="form-label" path="makeYear">Production Year</form:label>
              <form:input type="text" class="form-control" path="makeYear" id="makeYear" placeholder="Ex. 2018"/>
            </div>
            
            <div class="col-12">
              <form:label for="amount" class="form-label" path="amount">Price</form:label>
              <div  class="input-group">
	              <span class="input-group-text">$</span>
	              <form:input type="text" class="form-control" path="amount" id="amount" placeholder="00.00"/>
              </div>
            </div>
			
          <hr class="my-4">

          <button class="w-100 btn btn-primary btn-lg" type="submit">Post Car</button>
          </div>
        </form:form>
      </div>
      </div>
     </div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
</body>
</html>