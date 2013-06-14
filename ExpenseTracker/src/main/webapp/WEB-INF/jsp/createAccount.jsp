<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta charset="utf-8">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/createAccount.css">
<link rel="stylesheet" href="css/button.css">
<title>Log Your Expenses</title>
</head>
<body>
	<div id="wrap">
		<jsp:include page="header.jsp"></jsp:include>
		<div id="navigation">
			<p>
				<a href="login?page=home">Home</a><a href="login?page=aboutus">About
					us</a>
			</p>
		</div>
		<div id="account">
			<form id="accountForm" action="CreateAccount?action=create" method="post">
				<p>First Name</p>
				<p>
					<input name="firstName" type="text" class="fieldSize" />
				</p>
				<p>Last Name</p>
				<p>
					<input name="lastName" type="text" class="fieldSize" />
				</p>
				<p>Email</p>
				<p>
					<input name="email" type="text" class="fieldSize" />
				</p>
				<p>Password</p>
				<p>
					<div style="color:red;"> ${errorMessage} </div>
					<input name="password" type="password" class="fieldSize" />
				</p>
				<p>Confirm Password</p>
				<p>
					<input name="password1" type="password" class="fieldSize" />
				</p>
				<p>Gender</p>
				<p>
					<select class="fieldSize" name="gender">
						<option value="select">....</option>
						<option value="male">Male</option>
						<option value="female">Female</option>
					</select>
				</p>
				<p>Location</p>
				<p>
					<select class="fieldSize" name="location">
						<option>....</option>
						<c:forEach items="${locations}" var="location">
							<option value="${location}">${location}</option>
						</c:forEach>
					</select>
				</p>
				<p>
					<input type="submit" name="create" value="Create" id="create"
						class="button" />
				</p>
			</form>
		</div>
		<div id="content">
			<img src="image/GraphExpense.JPG" width="600" height="400" />
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>