<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="/ExpenseTracker/resources/css/common.css">
<link rel="stylesheet" href="/ExpenseTracker/resources/css/expense.css">
<link rel="stylesheet" href="/ExpenseTracker/resources/css/button.css">
<link rel="stylesheet" href="/ExpenseTracker/resources/css/addExpense.css">
<script src="addExpense.js"></script>
<title>Manage Your Expenses</title>
</head>
<div id="wrap">
	<jsp:include page="header.jsp"></jsp:include>
   	<jsp:include page="navigation.jsp"></jsp:include>
    <div id="content">
    	<form action="" method="get">
        	<table id="table">
            	<tr>
                	<th>Date</th>
                    <th>Category</th>
                    <th>SubCategory</th>
                    <th>Amount</th>
                    <th>Note</th>
                </tr>
                <tr>
                	<td><input name="e11" type="date" /></td> 	
                    <td><select name="e12">
                    		<option value="Select">Select</option>
  							<option value="Housing">Housing</option>
  							<option value="Daily">Daily</option>
  							<option value="Transport">Transport</option>
  							<option value="Fun">Fun</option>
						</select>
                    </td>
                    <td><select name="e13">
                    		<option value="Select">Select</option>
  							<option value="Landline Phone">Landline Phone</option>
  							<option value="Internet">Internet</option>
  							<option value="Mobile Phone">Mobile Phone</option>
  							<option value="Credit Cards">Credit Cards</option>
						</select>
                    </td>
                    <td><input name="e14" type="text" size="10" /></td>
                    <td><input name="e15" type="text" size="50" /></td>
                </tr>
                <tr>
                	<td><input name="e21" type="date" /></td>
                    <td><select name="e22">
                    		<option value="Select">Select</option>
  							<option value="Housing">Housing</option>
  							<option value="Daily">Daily</option>
  							<option value="Transport">Transport</option>
  							<option value="Fun">Fun</option>
						</select>
                    </td>
                    <td><select name="e23">
                    		<option value="Select">Select</option>
  							<option value="Landline Phone">Landline Phone</option>
  							<option value="Internet">Internet</option>
  							<option value="Mobile Phone">Mobile Phone</option>
  							<option value="Credit Cards">Credit Cards</option>
						</select>
                    </td>
                    <td><input name="e24" type="text" size="10" /></td>
                    <td><input name="e25" type="text" size="50" /></td>
                </tr>
            </table>
            <p><a href="#" onClick="addRow();"><img src="image/add.png" /></a></p>
            <input class="button" type="submit" type="submit" value="Add" />
        </form>
        <table>
            	<tr id="hiddenRow">
                	<td><input name="e21" type="date" /></td>
                    <td><select name="e22">
                    		<option value="Select">Select</option>
  							<option value="Housing">Housing</option>
  							<option value="Daily">Daily</option>
  							<option value="Transport">Transport</option>
  							<option value="Fun">Fun</option>
						</select>
                    </td>
                    <td><select name="e23">
                    		<option value="Select">Select</option>
  							<option value="Landline Phone">Landline Phone</option>
  							<option value="Internet">Internet</option>
  							<option value="Mobile Phone">Mobile Phone</option>
  							<option value="Credit Cards">Credit Cards</option>
						</select>
                    </td>
                    <td><input name="e24" type="text" size="10" /></td>
                    <td><input name="e25" type="text" size="50" /></td>
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