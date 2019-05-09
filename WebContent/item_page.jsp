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
<%@page import="java.util.*"%>
<%@page import="java.util.Collections"%>


<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>BuyMe Item</title>
	</head>
	<body>
		<h1>Item Page</h1>
		<div>
   <% 
  
%>
		</div>

		<div>
			<h1>Bid Information:</h1>
			<form action="Bid_handler2" method="POST">
				Place Your Bid :$
				<input type="text" name="bid_price"></input>
				<input type="submit" value="Submit">
			</form>
		</div>
	
		<div class="actions">
			<form name="_alert" action="_alert_handler?item_num=<%=item_num%>" method="post">
			<input type="submit" value="_alert">
			</form>
			<form name="watchlist" action="Add_to_watchlist_handler?item_num=<%=item_num%>" method="post">
			<input type="submit" value="watchlist">
			</form>
		</div>
	</body>
</html>
