<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta charset="utf-8">
<link rel="stylesheet" href="css/common.css">
<title>Manage Your Expenses</title>
</head>
<body style="color:red;">
	<div id="wrap">
		<jsp:include page="header.jsp"></jsp:include>
		<div id="navigation">
			<p>
				<a href="login?page=home">Home</a><a href="login?page=aboutus">About us</a>
			</p>
		</div>
		<div id="errorPage">
			<p style="font-size: 24px; color: red;">Error!!!</p>
			<p> ${param.error} </p>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>