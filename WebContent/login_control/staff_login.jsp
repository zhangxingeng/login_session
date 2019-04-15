<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="bean.Login_Bean"%>
<html>
<head>
<title>BuyMe_Staff_Login</title>
</head>
<body>
   <h1 class="content center big"> BuyMe</h1>
        
    <div class="conetent leftpad">
        
        <form action="loginHandler.jsp" method="POST">
            <input type="text" name="username" placeholder="Username"> <br>
            <input type="password" name="password" placeholder="Password"> <br>
            <input type="submit" value="Login">
        </form>
        <a href="register.jsp">Don't have an account? Register here.</a>
    </div>
</body>
</html>