<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.Iterator"%>
<%@ page import="data.List_item_data"%>
<%@ page import="data.Account_data"%>
<%@ page import="java.io.*,java.util.*,java.sql.*,java.text.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>BuyMe Item</title>
	</head>
<body>
    <h1 class="content center big">Item Page</h1>
<%
if(((Account_data)session.getAttribute("Account_data")).getType() = null ) { 
	response.sendRedirect("Login_handler");
} else {
%>
    <div class="conetent leftpad">
        <%
		
				DBConnect DBC = new DBConnect();
				Connection conn = DBC.getConn();
				PreparedStatement ps = null;
				ResultSet rs = null;
						
				try {
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					conn = DriverManager.getConnection(url, "cs336admin", "cs336password");
					String user = (Account_data)session.getAttribute("user").toString();
					int item_num = (List_item_data)Integer.parseInt(request.getParameter("item_num"));
					String itemQuery = "SELECT title, description, catagory, pic1, pic2, pic3 FROM item WHERE item_num=?";
					ps1 = conn.prepareStatement(itemQuery);
					ps1.setInt(1, productId);
					
					rs = ps1.executeQuery();
					if (!rs.next()) {
						response.sendRedirect("error_page.jsp"); // Occurs if there is no row in Product table with the given productId
						return;
					} 
			%>
				
			
				
				<h2>Item Title: <%= rs.getString("title") %></h2> <br>
				Title: <%= rs.getString("title") %> <br>
				Description: <%= rs.getString("description") %> <br>
				Catagory: <%= rs.getString("pic1") %> <%= rs.getFloat("size") %> <br>
				Pic1: <%= rs.getString("pic2") %> <br>
				Pic2: <%= rs.getString("pic3") %> <br>
				End Date/Time: <%= rs.getString("endDate") %> <br>
				
   
    </div>
</body>
</html>
