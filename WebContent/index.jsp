<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="data.Login_data"%>
<%@page import="java.util.Iterator"%>
<%@ page import="data.List_item_data"%>

<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>BuyMe_Home</title>
	</head>
	
	<body>
		<div class="account">
<%
if(session.getAttribute("account_type") != null){
%>
		<h5>Hello,<%=(String)session.getAttribute("account_type")%>!</h5>
		<button onclick="logout_handler">logout</button>
<%
}else{
%>
		<form action="Login_handler">
			<h5>Log in</h5>
			<input type="radio" name="identity" value="user">user
			<input type="radio" name="identity" value="staff">staff
			<input type="radio" name="identity" value="admin">admin
			Username
			<input type="text" name="username" required> <br>
			Password
			<input type="password" name="password" required><br>
			<input type="submit" value="Submit">
		</form>
		<button onclick="register.jsp">register</button>
<%
}
%>
		</div>
		
		<div class="search">
			<form action="Search_handler.jsp">
		      <input type="text" placeholder="Search.." name="search">
		      <button type="submit">Submit</button>
		    </form>
		</div>
		
		<div class="item_list">
		
		<c:forEach items="${search_result}" var="item">
			<tr>
				<td>${item.getTitle()}</td>
				<td>${item.getDescription}</td>
				<td>${item.getDate()}</td>
				<td>${item.getCurr_price()}</td>
				<td><input name="bid_price"></td>
				<td><button>Bid</button></td>
			</tr>
		</c:forEach>
		</div>
	</body>
</html>
