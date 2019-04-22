<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="data.List_item_data"%>
<%@ page import="data.Account_data"%>
<%@ page import="connect.DBConnect"%>
<%@page import="java.sql.*"%>
<%@page import="javax.servlet.*"%>
<%@page import="data.List_answer_data"%>
<%@page import="data.List_question_data"%>
<%@page import="data.Account_data"%>



<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>BuyMe Item</title>
	</head>
<body>
<h1 class="content center big">Item Page</h1>

<div class="Item Info">
 
		<table align="center" cellpadding="5" cellspacing="5" border="1">

		<tr></tr>
		<tr>
		<td><b>Title</b></td>
		<td><b>Description</b></td>
		<td><b>Brand</b></td>
		<td><b>Model</b></td>
		<td><b>RAM</b></td>
		<td><b>ROM</b></td>
		<td><b>OS</b></td>
		<td><b>Starting Price</b></td>

		</tr>
			<c:forEach var="item_detail">
				<tr>			
					<td>${item_detail.getTitle()}</td>
					<td>${item_detail.getDescription()}</td>
					<td>${item_detail.getModel()}</td>
					<td>${item_detail.getOs()}</td>
					<td>${item_detail.getBrand()}</td>
					<td>${item_detail.getRam()}</td>
					<td>${item_detail.getRom()}</td>
					<td>${item_detail.getCup_core()}</td>
					<td>${item_detail.getStart_price()}</td>
					</tr>
		</table>
	<% //QUESITONA DN ANSWERS FOR THE ITEM %>
	</div>
	<div class="Questiona and Answers">

		<h2>Question and Answers</h2>
			<table border="1">
				<tr>
				<td>Question</td>
				<td>Answer</td>
				</tr>
					<c:forEach var="Question">
					<tr>
					<td>${item_detail.getQuestion()}</td>
					<td>${item_detail.getAnswer()}</td>
					</tr>
			</table>

	</div>

	<% //BID FOR THIS ITEM %>
	<div>
		<h1>Bid Information:</h1>


		current price <label>${item_detail.getPrice()}</label>
		<form action="Place_bid_handler" method="POST">
			Place Your Bid <input type="number"></input>
			<input type="submit" value="Submit">
		</form>
	</div>

	<div class="actions">
		<button onclick="set_alert.java">Set Alert</button>
		<button onclick="add_to_watch_list.java">Add to watch list</button>
	</div>
</body>
</html>
