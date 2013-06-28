<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="/ExpenseTracker/resources/css/common.css">
<link rel="stylesheet" href="/ExpenseTracker/resources/css/category.css" />
<link rel="stylesheet" href="/ExpenseTracker/resources/css/button.css">
<script type="text/javascript" src="/ExpenseTracker/resources/jquery/jquery-2.0.2.js"></script>
<script src="/ExpenseTracker/resources/js/category.js"></script>
<title>Manage Your Expenses</title>
</head>
<div id="wrap">
	<jsp:include page="header.jsp"></jsp:include>
   	<jsp:include page="navigation.jsp"></jsp:include>
    <div id="content">
    	<div id="addCategory">
    		<button class="button" onclick="createCategory()">Create new Category</button>
    	</div>
    	<div id="category">
    		<table id="categoryTable" border="1">
    			<tr>
    				<th>Category</th>
    			</tr>
    			<c:forEach items="${categories}" var="categoryBean">
    			<tr>
    				<td><a href="#" onclick="onClickButton(this)" class="category">${categoryBean.categoryName}</a></td>
    				<td><img src="/ExpenseTracker/resources/image/cross.png"> </td>
    			</tr>
    			</c:forEach>
    		</table>
    	</div>
    </div>
    <div id="footer">
    	<p>COPYRIGHT (C) 2013 SITENAME.COM. ALL RIGHTS RESERVED. DESIGN BY MANISH VEERWAL</p>
    </div>
</div>
<body>
</body>
</html>