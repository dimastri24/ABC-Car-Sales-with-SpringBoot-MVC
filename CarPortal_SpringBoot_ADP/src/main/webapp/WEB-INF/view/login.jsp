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
<!-- <link href="/style/bootstrap.min.css" rel="stylesheet" /> -->
<link href="/style/style.css" rel="stylesheet" />
<title>Login</title>
</head>
<body>
<%@ include file="header.jsp"%>
<section class="vh-100">
  <div class="container-fluid h-custom">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-md-9 col-lg-6 col-xl-5">
        <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
          class="img-fluid" alt="Sample image">
      </div>
      <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
		<h2 class="text-center mb-3">Login</h2>
		<c:if test="${error_msg != null}">
			<div class="alert alert-danger">${error_msg}</div>
		</c:if>
		
		<c:url var="post_url" value="/login" />
        <form action="${post_url}" method="post">
		  <input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
						
          <!-- Email input -->
          <div class="form-outline mb-4 form-floating">
            <input type="text" id="username" class="form-control form-control-lg"
              placeholder="Enter a valid UserName" name="username"/>
            <label class="form-label" for="username">Enter UserName</label>
          </div>

          <!-- Password input -->
          <div class="form-outline mb-3 form-floating">
            <input type="password" id="password" class="form-control form-control-lg"
              placeholder="Enter password" name="password"/>
            <label class="form-label" for="password">Enter Password</label>
          </div>

          <div class="text-center text-lg-start mt-4 pt-2">
            <button type="submit" class="btn btn-primary btn-lg"
              style="padding-left: 2.5rem; padding-right: 2.5rem;" name="Login">Login</button>
            <p class="small fw-bold mt-2 pt-1 mb-0">Don't have an account? <a href="register"
                class="link-danger">Register</a></p>
          </div>

        </form>
      </div>
    </div>
  </div>
</section>

<%@ include file="footer.jsp"%>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
</body>
</html>