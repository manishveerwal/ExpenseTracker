<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="/ExpenseTracker/resources/css/common.css">
<link rel="stylesheet" href="/ExpenseTracker/resources/css/button.css">
<link rel="stylesheet" href="/ExpenseTracker/resources/css/expense.css">
<script src="expenselog.js"></script>
<title>Log Your Expenses</title>
</head>
<div id="wrap">
	<jsp:include page="header.jsp"></jsp:include>
    <jsp:include page="navigation.jsp"></jsp:include>
    <div id="content">
    	<form method="post" action="addExpense">
    		<input id="addButton" class="button" type="submit" type="submit" value="Add Expenses" />
    	</form>
    	<table id="dataTable">
            	<tr>
                	<th style="width:10%;">Date</th>
                    <th style="width:10%;">Category</th>
                    <th style="width:10%;">SubCategory</th>
                    <th style="width:5%;">Amount</th>
                    <th style="width:60%;">Note</th>
                    <th style="width:5%;">Delete</th>
                </tr>
                <tr id="1">
                	<td>15/04/2013</td> 	
                    <td>Housing</td>
                    <td>Rent</td>
                    <td>8000 Rs</td>
                    <td>Rent ksxksjloslckjkjkfor Sparklets B2 301</td>
                    <td><a href="#" onClick="deleteRow(1);"><img src="image/cross.png" /></a></td>
                </tr>
                 <tr id="2" class="alt">
                	<td>16/04/2013</td> 	
                    <td>Housing</td>
                    <td>Rent</td>
                    <td>8000 Rs</td>
                    <td>Rent ksxksjloslckjkjkfor Sparklets B2 301</td>
                    <td><a href="#" onClick="deleteRow(2);"><img src="image/cross.png" /></a></td>
                </tr>
                <tr id="3">
                	<td>17/04/2013</td> 	
                    <td>Housing</td>
                    <td>Rent</td>
                    <td>8000 Rs</td>
                    <td>Rent ksxksjloslckjkjkfor Sparklets B2 301</td>
                    <td><a href="#" onClick="deleteRow(3)"><img src="image/cross.png" /></a></td>
                </tr>
                <tr id="4">
                	<td>18/04/2013</td> 	
                    <td>Housing</td>
                    <td>Rent</td>
                    <td>8000 Rs</td>
                    <td>Rent ksxksjloslckjkjkfor Sparklets B2 301</td>
                    <td><a href="#" onClick="deleteRow(4);"><img src="image/cross.png" /></a></td>
                </tr>
                <tr id="5">
                	<td>19/04/2013</td> 	
                    <td>Housing</td>
                    <td>Rent</td>
                    <td>8000 Rs</td>
                    <td>Rent ksxksjloslckjkjkfor Sparklets B2 301</td>
                    <td><a href="#" onClick="deleteRow(5);"><img src="image/cross.png" /></a></td>
                </tr>
                <tr id="6">
                	<td>20/04/2013</td> 	
                    <td>Housing</td>
                    <td>Rent</td>
                    <td>8000 Rs</td>
                    <td>Rent ksxksjloslckjkjkfor Sparklets B2 301</td>
                    <td><a href="#" onClick="deleteRow(6);"><img src="image/cross.png" /></a></td>
                </tr>
         </table>
    </div>
    <div id="footer">
    	<p>COPYRIGHT (C) 2013 SITENAME.COM. ALL RIGHTS RESERVED. DESIGN BY MANISH VEERWAL</p>
    </div>
</div>
<body>
</body>
</html>