<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.Iterator"%>
<%@ page import="data.List_item_data"%>
<%@ page import="data.Account_data"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BuyMe_Home</title>
</head>
<body>
	<h1 class="content center big">item upload</h1>

	<div class="conetent leftpad">

		<form action="Seller_handler" method="POST">
			Name<input type="text" name="title" required><br>
			Description<input type="text" name="description" required><br>
			Brand: <select>
				<option value="apple">Apple</option>
				<option value="samsung">Samsung</option>
				<option value="google">google</option>
				<option value="sony">Sony</option>
				<option value="huawei">Huawei</option>
				<option value="other">Other</option>
			</select> model<input type="text" name="model" required><br>
			Start Price<input type="text" name="start_price" required><br>
			Minimum reserve Proce<input type="text" name="description"><br>

		</form>

	</div>
</body>
</html>
