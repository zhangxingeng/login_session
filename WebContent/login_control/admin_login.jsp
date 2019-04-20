<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="data.Account_data"%>

<html>
<head>
<title>BuyMe_Admin_Login</title>
</head>
<body>
  <h1 class="content center big">BuyMe - Admin Login</h1>
    <div class="conetent leftpad">
        <form action="admin_page.html" method="POST">
            <input type="text" name="email" placeholder="Email"> <br>
            <input type="password" name="password" placeholder="Password"> <br>
            <input type="submit" value="Login">
        </form>
    </div>
</body>
</html>