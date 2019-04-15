<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="bean.Login_Bean"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>BuyMe_User_Login</title>
	</head>
	<body>
		<center>	
		 <%
			 Login_Bean loginfo = (Login_Bean)(session.getAttribute("userSession"));
			 if(loginfo == null){
		 %>
		 	<h3>Login Here</h3>
		 	<form action="./Login_check.jsp" method="post"> 
				Enter User Name
				<input type="text" name="username" required> <br>
				Enter Password
				<input type="password" name="password" required><br>
				<input type="submit" value="Submit">
			</form> 
			<% 
				 String message = (String)(session.getAttribute("loginMessage"));
				 if(message != null){
					 out.println(message);
					 session.removeAttribute("loginMessage");
				 }
			}else{
			%>
			<h1>Home Page</h1>
			<table border="1">
				<tr>
					<td><a href="./home.jsp">Home</a> </td>
					<td><a href="./home.jsp">Profile</a> </td>
					<td>Welcome <%=loginfo.getUsername()%></td>
					<td><a href="./signOut.jsp">Log Out</a></td>
				</tr>
			</table>
			<%
		 			}
			%>
		</center>
	</body>
</html>