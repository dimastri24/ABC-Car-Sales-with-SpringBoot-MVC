<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- <link href="/style/bootstrap.min.css" rel="stylesheet" /> -->
<link href="/style/style.css" rel="stylesheet" />
<title>Thank You</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container mb-5">
		<h2 class="d-flex justify-content-center mt-1">Registration Complete</h2>
		<img class="mx-auto d-block" width="360" alt="green-check" src="img/green-check.png">
		<div class="d-flex flex-column align-items-center justify-content-center bg-light mx-auto py-4 rounded"
			style="width: 50%">
			<p>Thank you ${name} for join us.</p>
			<p>Please click <span style="text-decoration: underline;">Login</span> below to do a login</p>
			<button class="btn btn-primary" onclick="window.location.href='login';">Login</button>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
</body>
</html>