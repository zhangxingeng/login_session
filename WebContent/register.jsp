<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="data.Account_data"%>
<html>
<head>
<title>BuyMe_User_Register</title>
</head>
<body>
	<h1 class="content center big">BuyMe</h1>
	<div class="centent leftpad">
		<form action="Register_handler" method="POST">
			Email<input type="text" name="email" required><br>
			Address<input type="text" name="address"><br> User_name<input
				type="text" name="username" id="username"><br> Password
			<input type="password" name="password" required> <br>
			confirm_password<input type="password" name="confirm_password"><br>
			<input type="submit" value="Register">
		</form>
	</div>

</body>
</html>