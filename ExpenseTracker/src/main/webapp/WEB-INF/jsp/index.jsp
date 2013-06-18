<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta charset="utf-8">
<link rel="stylesheet" href="<c:url value="/resources/css/common.css" />">
<link rel="stylesheet" href="<c:url value="/resources/css/login.css" />">
<link rel="stylesheet" href="<c:url value="/resources/css/button.css" />">
<title>Manage Your Expenses</title>
</head>
<body>
	<div id="wrap">
		<jsp:include page="header.jsp"></jsp:include>
		<div id="navigation">
			<p>
				<a href="home">Home</a><a href="aboutus">About us</a>
			</p>
		</div>
		<div id="login">
			<form id="register" action="CreateAccount">
				<div class="loginBox">Don't have an account?</div>
				<div class="loginBox" id="account">
					<input type="hidden" name="page" value="createAccount" /> <input
						id="createAccountButton" class="button" type="submit"
						value="Create an Account" />
				</div>
			</form>
			<div class="loginBox">
				<span>Sign in</span> <img
					src="<c:url value="/resources/image/38px-Gold_Currency_Symbols.svg.png" />" width="20" />
			</div>
<%-- 			<form id="loginform" action="logon" method="post"> --%>
<!-- 				<div class="loginBox"> -->
<!-- 					<div class="loginField">Email</div> -->
<!-- 					<div> -->
<!-- 						<input name="email" type="text" class="textField" /> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 				<div class="loginBox"> -->
<!-- 					<div class="loginField">Password</div> -->
<!-- 					<div> -->
<!-- 						<input name="password" type="password" class="textField" /> -->
<!-- 					</div> -->
<!-- 				</div> -->
<%-- 				<div style="font-size:16px; color: red; font-weight: bold;">${errorMessage}</div> --%>
<!-- 				<div id="button" class="loginBox"> -->
<!-- 					<input class="button" type="submit" value="Sign in" /> -->
<!-- 				</div> -->
<%-- 			</form> --%>
			<form:form id="loginForm" action="logon" method="post" modelAttribute="logonBean">
				<div class="loginBox">
					<div class="loginField">Email</div>
					<div>
						<form:errors path="email" />
						<form:input path="email" />
					</div>
				</div>
				<div class="loginBox">
					<div class="loginField">Password</div>
					<div>
						<form:errors path="password"/>
						<form:input path="password" />
					</div>
				</div>
				<div id="button" class="loginBox">
					<input class="button" type="submit" value="Sign in" />
				</div>
			</form:form>
		</div>
		<div id="content">
			<img src="<c:url value="/resources/image/GraphExpense.JPG" />" width="600" height="400" />
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>