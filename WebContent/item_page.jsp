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
		<h1 class="content center big">Item Page</h1>
		<div class="Item Info">
		    <% List_item_data detail= (List_item_data)(session.getAttribute("item_detail"));%> 
			<table align="center" cellpadding="5" cellspacing="5" border="1">
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
				<tr>			
					<td><%=detail.getTitle()%></td>
					<td><%=detail.getDescription()%></td>
					<td><%=detail.getModel()%></td>
					<td><%=detail.getOs()%></td>
					<td><%=detail.getBrand()%></td>
					<td><%=detail.getRam()%></td>
					<td><%=detail.getRom()%></td>
					<td><%=detail.getCpu_core()%></td>
					<td><%=detail.getStart_price()%></td>
				</tr>
			</table>
		</div>
		<div class="Question and Answers">
			<h2>Question and Answers</h2>
<% 
//@SuppressWarnings("unchecked")
LinkedList<List_question_data> questions = (LinkedList<List_question_data>)(session.getAttribute("question"));
while(!questions.isEmpty()){
	List_question_data curr_question = questions.pop();
	//print out questions here
	LinkedList<List_answer_data> answers = curr_question.getAnswers();
	while(!answers.isEmpty()){
		List_answer_data curr_answer = answers.pop();
		//print out answers here
	}
}
%>
		</div>
	
		<% //BID FOR THIS ITEM %>
		<div>
			<h1>Bid Information:</h1>
			current price <label>${item_detail.getCurr_price()}</label>
			<form action="Bid_handler" method="POST">
				Place Your Bid :$
				<input type="number" name="bid_price"></input>
				<input type="submit" value="Submit">
			</form>
		</div>
	
		<div class="actions">
			<button onclick="set_alert.java">Set Alert</button>
			<button onclick="add_to_watch_list.java">Add to watch list</button>
		</div>
	</body>
</html>
