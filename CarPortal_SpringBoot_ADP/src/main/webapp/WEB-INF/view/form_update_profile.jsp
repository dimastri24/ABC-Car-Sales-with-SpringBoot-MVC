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
<title>EDIT PROFILE</title>
</head>
<body>
<%@ include file="header.jsp"%>
	<h1 class="d-flex justify-content-center mb-3">Edit Profile</h1>
	<div
		class="align-items-center justify-content-center mx-auto pt-3 pb-5 px-5 rounded col-lg-8 col-md-10 container"
		 style="border-top-left-radius: .5rem; border-bottom-left-radius: .5rem; background-color: #f4f5f7;">
		<form:form method="post" id="editProfile" action="update_profile" modelAttribute="user">
			<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
			<div class="mb-3">
				<form:input class="form-control" path="id"
					name="id" id="id" hidden="hidden"/>
			</div>
			<div class="mb-3">
				<form:label class="form-label" for="name" path="name">Name</form:label>
				<form:input type="text" class="form-control" path="name"
					name="name" id="name" />
			</div>
			<div class="mb-3">
				<form:label class="form-label" for="phoneNumber" path="phoneNumber">Phone Number</form:label>
				<form:input type="text" class="form-control" name="phoneNumber" id="phoneNumber" path="phoneNumber"/>
			</div>
			<div class="mb-3">
				<form:label class="form-label" for="address" path="address">Address</form:label>
				<form:input type="text" class="form-control" name="address" id="address"  path="address"/>
			</div>
			<button type="submit" class="btn btn-primary" id="update"
				name="update">Save</button>
		</form:form>
	</div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
</body>
</html>