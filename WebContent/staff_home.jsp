<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="data.List_item_data"%>
<%@ page import="data.Account_data"%>
<%@ page import="connect.DBConnect"%>
<%@ page import="javax.servlet.*"%>
<%@ page import="data.List_answer_data"%>
<%@ page import="data.List_question_data"%>
<%@ page import="data.Account_data"%>
<%@ page import="java.sql.*"%>


<html>
	<head>
		<title>Customer Rep Page</title>
	</head>
	<body>



 		<div class="user info modification">
		 	<form action="Edit_user_handler">
				<h5>Change User Information</h5>
				<input type="radio" name="identity" value="change_address">Change Address 
				<input type="radio" name="identity" value="change_username">Change Username
				<input type="radio" name="identity" value="change_password">Change Password
					
				Enter User's Email<input type="text" name="email"><br>
				Enter New<input type="text" name="address"><br>
				<input type="submit" value="Change">
			</form>
		</div>
		<div class="Questiona and Answers">
			<h2>Question and Answers</h2><br>
			please input item#:
			<form action = "staff_home.jsp">
				<input type = "text" name="item_num"><input type="submit" value="Submit">
			</form>
<%
String item_num = request.getParameter("item_num");
DBConnect dsconn = new DBConnect();
Connection conn = dsconn.getConn();

PreparedStatement ps = null;
ResultSet rs = null;
String query_find_item = "SELECT * FROM item WHERE item_num = ?";
ps = conn.prepareStatement(query_find_item);
ps.setString(1, item_num);
rs = ps.executeQuery();

if(rs.next()){
%>
			<table>
				<tr>
					<td>Unanswered Question</td>
					<td>Answer</td>
				</tr>
<%
	/*
	String q_quest_num = quest.getQuestion_num();
	String q_item_num = quest.getItem_num();
	String a_quest_num = ans.getQuestion_num();
	String item_num = request.getParameter("detail");
	*/
	String q_and_a_query = "Select q.question FROM question q WHERE q.question_num NOT IN(SELECT a.question_num FROM answer a)"; 
	ps = conn.prepareStatement(q_and_a_query);
	rs = ps.executeQuery();
	while(rs.next()){
%>
				<tr>
					<td><%=rs.getString("question") %></td>
					<td>
					<form action="answer_handler?ques_num=<%=rs.getString("question_num")%>" method="POST">
						<input type="text" name="answer"/>
						<input type="submit" name="answer_button" value="<%=rs.getString("question_num")%>">
					</form>
					</td>
				</tr>
        	</table>
<%
	}
} else {
%>
			<p>Sorry this item does not exist.</p>
<%
}
%>
		</div>
	</body>
</html>