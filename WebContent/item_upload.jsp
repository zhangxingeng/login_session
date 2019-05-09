<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="data.List_item_data"%>
<%@ page import="data.Account_data"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BuyMe_Home</title>
</head>
<body>
	<h1 class="content center big">item upload</h1>

	<div>
	<%
	if(session.getAttribute("message") != null){
		out.println((String)session.getAttribute("message"));
	}
	%>
		<form action="Seller_handler" method="POST">
			Name<input type="text" name="title" maxlength="50" required><br>
			Description<input type="text" name="description" required><br>

			Phone Model<input type="text" name="model" required><br>
			Phone OS<input type="text" name="os" required><br>
			RAM<input type="number" name="ram" required><br>
			ROM<input type="number" name="rom" required><br>
			
			Brand: <input type="text" name="brand" required><br>
      
			CPU Core<input type="text" name="cpu_core" required><br>
			Start Price<input type="number" name="start_price" required><br>
			Minimum reserve Price<input type="text" name="description"><br>
			<input type="submit" value="Submit">
		</form>
	</div>
</body>
</html>