<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>

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
	<title>Message Page</title>
	</head>
	<body>
	<div class="message">
		<h3>Your Messages:</h3>
<%

DBConnect dbc = new DBConnect();
Connection conn = dbc.getConn();
PreparedStatement ps = null;
ResultSet rs = null;

Account_data userinfo = (Account_data)session.getAttribute("account_info"); 
String useremail = userinfo.getEmail();
String query_get_message = "SELECT * FROM email e WHERE e.reciver_email = ?";
ps = conn.prepareStatement(query_get_message);
ps.setString(1, useremail);
rs = ps.executeQuery();
while(rs.next()){
%>
		<h5>From: <%=rs.getString("sender_email") %></h5>
		<h4> Message: <%= rs.getString("message") %></h4>
		
<%
}
%>
	</div>
	</body>
</html>




