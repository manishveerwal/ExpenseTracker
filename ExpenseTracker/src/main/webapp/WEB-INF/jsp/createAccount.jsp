<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta charset="utf-8">
<link rel="stylesheet" href="/ExpenseTracker/resources/css/common.css">
<link rel="stylesheet" href="/ExpenseTracker/resources/css/createAccount.css">
<link rel="stylesheet" href="/ExpenseTracker/resources/css/button.css">
<script type="text/javascript" src="/ExpenseTracker/resources/jquery/jquery-2.0.2.js"></script>
<script type="text/javascript">
	$(document).ready(function (){
		$("#email").blur(function(){
			if($("#email").val() == ""){
				$("#emailError").text("Please enter your email.");
			} else {
				$.getJSON("/ExpenseTracker/checkEmailAvailability?email="+$("#email").val(), function(available){
					if(available == false){
						$("#emailError").text("Your Email is Already Registered.");
					} else {
						$("#emailError").text("");
					}
				});
			}
		});
	});
</script>
<title>Log Your Expenses</title>
</head>
<body>
	<div id="wrap">
		<jsp:include page="header.jsp"></jsp:include>
		<div id="navigation">
			<p>
				<a href="home">Home</a><a href="aboutus">About
					us</a>
			</p>
		</div>
		<div id="account">
			<form:form id="accountForm" action="processRegistration" method="post" modelAttribute="registrationFormBean">
				<p>First Name</p>
				<p>
					<div><form:errors path="firstName" cssClass="error"/> </div>
					<form:input path="firstName" cssClass="fieldSize"/>
				</p>
				<p>Last Name</p>
				<p>
					<div><form:errors path="lastName" cssClass="error"/> </div>
					<form:input path="lastName" cssClass="fieldSize"/>
				</p>
				<p>Email</p>
				<p>
					<div id="emailError" class="error"><form:errors path="email" cssClass="error"/> </div>
					<form:input path="email" cssClass="fieldSize"/>
				</p>
				<p>Password</p>
				<p>
					<div style="color:red;"> ${errorMessage} </div>
					<div><form:errors path="password" cssClass="error"/> </div>
					<form:input path="password" cssClass="fieldSize" type="password"/>
				</p>
				<p>Confirm Password</p>
				<p>
					<form:input path="password1" cssClass="fieldSize" type="password"/>
				</p>
				<p>Gender</p>
				<div><form:errors path="gender" cssClass="error"/> </div>
				<p>
					<form:select path="gender">
						<option>....</option>
						<option value="male">Male</option>
						<option value="female">Female</option>
					</form:select>
				</p>
				<p>Location</p>
				<div><form:errors path="location" cssClass="error"/> </div>
				<p>
					<select class="fieldSize" name="location">
						<option>....</option>
						<c:forEach items="${locations}" var="location">
							<option value="${location}">${location}</option>
						</c:forEach>
					</select>
				</p>
				<p>
					<input type="submit" name="create" value="Create Account" id="create"
						class="button" />
				</p>
			</form:form>
		</div>
		<div id="content">
			<img src="/ExpenseTracker/resources/image/GraphExpense.JPG" width="600" height="400" />
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>