<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="data.Account_data"%>

<html>
<head>
<title>BuyMe_Admin_Home</title>
</head>
<body>
	<%
if(((Account_data)session.getAttribute("Account_data")).getType().equals("admin")){
%>
	<h5>Hello, Administrator!</h5>
	<button onclick="logout_handler">logout</button>


	<h2>Customer Representative Management</h2>
	<form action="AdminCRM_handler" method="post">
		<input type="radio" name="action" value="add">add <input
			type="radio" name="action" value="del">delete Email<input
			type="text" name="email"> Password<input type="text"
			name="password"> <br>
		<button type="submit" name="button" value="CR">Submit</button>
	</form>
	<br>

	<h3>Sales Reports</h3>
	<form action="Salesreport_handler" method="post">
		<input type="radio" name="report" value="totalearning">Total Earnings<br> 
		<input type="radio" name="report" value="earnperitem">Earnings per Item<br> 
		<input type="radio" name="report" value="earnpertype">Earnings per Item Type<br> 
		<input type="radio" name="report" value="earnperuser">Earnings per End User<br> 
		<input type="radio" name="report" value="bestsellitem">Bestselling Items<br> 
		<input type="radio" name="report" value="bestuser">Best Buyers<br> 
		<input type="submit" value=Submit>
	</form>

	<%
}else{
%>
	<script type="text/javascript">
	 window.location.href="index.jsp"
	</script>
	<%
}
%>

</body>
</html>