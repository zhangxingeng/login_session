<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="data.List_item_data"%>
<%@ page import="data.Account_data"%>
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
					String user = ((Account_data)session.getAttribute("account_info")).getName();
					//get item_numbr from buttons value(string) and query from database of all other info
					String itemQuery = "SELECT * FROM item i, phone_type t WHERE t.brand = i.brand AND t.model = i.model";
					ps1 = conn.prepareStatement(itemQuery);
					rs = ps1.executeQuery();
					while (rs.next()) {
						//print out all attributes from item table and phone type table
					} 
			%>
				
 
    </div>
</body>
</html>
