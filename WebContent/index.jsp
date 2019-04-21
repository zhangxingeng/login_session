<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="data.List_item_data"%>
<%@ page import="data.Account_data"%>

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
		<%
}else{
%>
		<form action="Login_handler">
			<h5>Log in</h5>
			<input type="radio" name="identity" value="user">user <input
				type="radio" name="identity" value="staff">staff <input
				type="radio" name="identity" value="admin">admin
			<div>
				Username <input type="text" name="username" required> <br>
				Password <input type="password" name="password" required><br>
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

	<div class="item_list">

		<c:forEach items="${search_result}" var="item">
			<tr>
				<td>title: ${item.getTitle()}</td>
				<td>Description: ${item.getDescription}</td>
				<td>${item.getDate()}</td>
				<td>${item.getCurr_price()}</td>
				<td><button onclick="item_detail.jsp" name="detail" value="${item.getItem_num()}">view</button></td>
			</tr>
		</c:forEach>
	</div>
</body>
</html>
