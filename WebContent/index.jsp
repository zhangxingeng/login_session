<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<title>BuyMe_Home</title>
	</head>

	<body>
		<div class="account">
<%
if(session.getAttribute("account_info") != null){
%>
			<h5>
				Hello,<%= ((Account_data)session.getAttribute("account_info")).getType() %>!
			</h5>
			<button onclick="logout_handler">logout</button>
			<button onclick="item_upload">upload new items</button>
			<button onclick="message_page">Message</button>
				
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
%>
			<p><%=rs.getString("from_email") %></p>
			<p><%=rs.getString("message") %></p>
<%
		}
		conn.close();
	}catch (Exception e){}
}
else{
%>
			<form action="Login_handler">
				<h5>Log in</h5>
				<input type="radio" name="identity" value="user">user <input
					type="radio" name="identity" value="staff">staff <input
					type="radio" name="identity" value="admin">admin
				<div>
					Username <input type="text" name="username" > <br>
					Password <input type="password" name="password" ><br>
					<input type="submit" value="Submit">
				</div>
			</form>
			<button onclick="register.jsp">register</button>
<%
}
%>
		</div>
	
		<div class="search">
			<form action="Search_handler.jsp" method="post">
				keyword:<input type="text" name="keyword"><br>
				brand:
				<select>
					<option value="apple">Apple</option>
					<option value="samsung">Samsung</option>
					<option value="google">google</option>
					<option value="sony">Sony</option>
					<option value="huawei">Huawei</option>
					<option value="other">Other</option>
				</select><br>
				model<input type="text" name="model"><br>
				min_price<input type="text" name="min_price"><br>
				max_price<input type="text" name="max_price"><br>
				<input type="radio" name="status" value="active">active item<br>
				<input type="radio" name="status" value="history">history item<br>
				<button type="submit">Submit</button>
			</form>
		</div>
		
		
	</body>
</html>
