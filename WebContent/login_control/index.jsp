<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="data.Account_data"%>
<%@page import="java.util.Iterator"%>
<%@ page import="data.List_item_data"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BuyMe_Home</title>
</head>
<body>
<div class="login">
	<a href="user_login.jsp">login as user</a>/
	<a href="register.jsp">register</a>/
	<a href="staff_login.jsp">login as worker</a>/
	<a href="admin_login.jsp">login as admin</a>
</div>

<div class="search">
	<form action="Search_process.jsp">
      <input type="text" placeholder="Search.." name="search">
      <button type="submit">Submit</button>
    </form>
</div>

<div class="item_list">

<c:forEach item="${search_result}" var="item">
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
