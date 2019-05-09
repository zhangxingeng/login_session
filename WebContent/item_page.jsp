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
<% 
if(session.getAttribute("message") != null){
	out.println((String)session.getAttribute("message"));
	session.removeAttribute("message");
}
%>
		<h1>Item Detail</h1>
		<div>
			${current_item.getTitle()}<br>
			${current_item.getDescription()}<br>
			${current_item.getModel()}<br>
			${current_item.getOs()}<br>
			${current_item.getBrand()}<br>
			${current_item.getRam()}<br>
			${current_item.getRom()}<br>
			${current_item.getCpu_core()}<br>
			${current_item.getStart_price()}<br>
			${current_item.getCurr_price()}<br>
			${current_item.getBid_count()}<br>

		</div>
		<div>
			<h1>Bid Information:</h1>
			<form action="Bid_handler" method="POST">
				Place Your Bid :$
				<input type="hidden" name="item_num" value="${current_item.getItem_num()}"/>
				<input type="text" name="bid_price"></input>
				<input type="submit" value="bid"></input>
			</form>
		</div>
	
		<div class="actions">
			<form name="set alert" action="alert_handler" method="post">
				<input type="submit" value="set alert">
			</form>
			<form name="add to watchlist" action="Add_to_watchlist_handler?item_num=" method="post">
			<input type="submit" value="add to watchlist">
			</form>
		</div>
	</body>
</html>
