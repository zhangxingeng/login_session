<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

 <%@ page import="java.util.ArrayList" %>
<%@ page import="javax.servlet.*"%>
<%@ page import="java.sql.*"%>

<%@ page import="connect.DBConnect"%>
<%@ page import="data.List_item_data"%>
<%@ page import="data.Account_data"%>
<%@ page import="data.List_answer_data"%>
<%@ page import="data.List_question_data"%>
<%@ page import="data.Account_data"%>
<%@ page import="request_handler.*"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>BuyMe_Home</title>
	</head>
	<body>
		<div class="account">
		
<%
if(session.getAttribute("account_info") != null){
%>
			<h5>Hello, <%=((Account_data)session.getAttribute("account_info")).getType()%>!</h5>
			<form name="account_management" action="Logout_handler" method="post">
				<input type="submit" value="logout">
			</form>
			<form name="account_management" action="item_upload" method="post">
				<input type="submit" value="upload new items">
			</form>
			<form name="account_management" action="message_page" method="post">
				<input type="submit" value="Message">
			</form>
						
<%
	Account_data curr_user = (Account_data)(session.getAttribute("account_info"));
	String curr_email = curr_user.getEmail();

	DBConnect DBC = new DBConnect();
	Connection conn = DBC.getConn();
	PreparedStatement ps = null;
	ResultSet rs = null;
	try{
		String email_query = "SELECT e.from_email e.message FROM Email e, Account a WHERE e.to_email = a.email";
		ps = conn.prepareStatement(email_query);
		rs = ps.executeQuery();
		while(rs.next()){
			out.println(""+rs.getString("from_email") );
			out.println(""+rs.getString("message") );
		}
		conn.close();
	}catch (Exception e){}
}
else{
%>
			<form action="Login_handler" method="POST">
				<h5>Log in</h5>
				<input type="radio" name="identity" value="user">user 
				<input type="radio" name="identity" value="staff">staff 
				<input type="radio" name="identity" value="admin">admin
				email <input type="text" name="email" > <br>
				Password <input type="password" name="password" ><br>
				<input type="submit" value="Submit">
			</form>
			
			<form name="register" action="register.jsp" method="POST">
				<input type="submit" value="register">
			</form>
<%
}
%>
		</div>
	
		<div class="search">
			<form action="Search_handler" method="post">
				keyword:<input type="text" name="keyword"><br>
				<input type="submit" value="submit">
			</form>
		</div>
	
		<div class="item_list">
<%
if(session.getAttribute("search_result") != null){
		ArrayList<?> search_result = (ArrayList<?>)session.getAttribute("search_result");
		while(!search_result.isEmpty()){
			List_item_data curr_item = (List_item_data)search_result.remove(0);
			out.println(curr_item.getTitle()+"<br>");
			out.println(curr_item.getCurr_price()+"<br>");
%>
			<form action="item_page.jsp?item_num=<%=curr_item.getItem_num()%>" method="post">
				<input type="submit" value="Check This Out!">
			</form>
<% 
		}
}
%>
		
		
<%
if(session.getAttribute("failure_message") != null){
	System.out.println((String)session.getAttribute("failure_message"));
}
%>
		
		</div>
	</body>
</html>


