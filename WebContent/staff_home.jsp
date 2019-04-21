<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	
		<h2>Question and Answers</h2>
			<table border="1">
				<tr>
				<td>Unanswered Question</td>
				<td>Answer</td>
				</tr>
        
        		<%
        		try{
        			/*
        			String q_quest_num = quest.getQuestion_num();
        			String q_item_num = quest.getItem_num();
        			String a_quest_num = ans.getQuestion_num();
        			String item_num = request.getParameter("detail");
        			*/
        			String query = "Select q.question FROM question q WHERE q.question_num NOT IN(SELECT a.question_num FROM answer a)"; 
        			ps = conn.prepareStatement(q_and_a_query);
					rs = ps.executeQuery();
					while(rs.next()){
						%>
						
						<tr>
						<td><%=rs.getString("question") %></td>
						<td><input type="text" name="fname" /></td>
						<td><input type="submit" value="Submit"></td>
						</tr>
						
						<% 
					}
					conn.close();
        		} catch (Exception e) {
        			e.printStackTrace();
        		}
        		%> 
        </table>
	
	</div>
</body>
</html>