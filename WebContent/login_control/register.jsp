<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="bean.Login_Bean"%>
<html>
<head>
<title>BuyMe_User_Register</title>
</head>
<body>
  <h1 class="content center big">BuyMe</h1>
    <div class="centent leftpad">
        <form action="registerHandler.jsp" method="POST">
    

            <label for="Email">Email</label>
            <input type="text" name="email" placeholder="Email"> <br>
    
            <label for="Address">Address</label>
            <input type="text" name="address" placeholder="Address"> <br>
            
            <label for="username">Username</label>
            <input type="text" name="username" id="username" placeholder="Username"> <br>
    
            <label>Password</label>
            <input type="password" name="password" placeholder="Password"> <br>
    
            <label>Confirm Password</label>
            <input type="password" name="confirm_password" placeholder="Confirm Password"> <br>
    
            <input type="submit" value="Register">
        </form>
    </div>
	
</body>
</html>