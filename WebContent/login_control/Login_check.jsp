<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import = "get.Login_Modal" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content = "text/html">
	</head>
	<body>
		<jsp:useBean id="loginfo" class="data.Login_data"></jsp:useBean> 
		<jsp:setProperty property="*" name="loginfo"/>
<%
	Login_Modal loginModal = new Login_Modal();
	boolean flag = loginModal.checkUserName(loginfo);
	if(flag){
		session.setAttribute("userSession",loginfo);
%>
		<script type="text/javascript">
			window.location.href="./home.jsp";//login success goto page
		</script>
<%
	}else{
		session.setAttribute("loginMessage", "Login Failed");
%>
		<script type="text/javascript">
			window.location.href="./home.jsp";//login success goto page
		</script>
<%
	}
%>
	</body>
</html>