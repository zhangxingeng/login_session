<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="data.List_item_data"%>
<%@ page import="data.Account_data"%>
<%@ page import="connect.DBConnect"%>
<%@page import="java.sql.*"%>
<%@page import="javax.servlet.*"%>



<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>BuyMe Item</title>
	</head>
<body>
    <h1 class="content center big">Item Page</h1>

    <div>
        

        
        
        <%
				DBConnect DBC = new DBConnect();
				Connection conn = DBC.getConn();
				PreparedStatement ps = null;
				ResultSet rs = null;
		%>
		
		<table align="center" cellpadding="5" cellspacing="5" border="1">

		<td><b>Model</b></td>
		<td><b>RAM</b></td>
		<td><b>ROM</b></td>
		<td><b>OS</b></td>
		<td><b>Starting Price</b></td>
		</tr>
        
		
        
        <%
		
				DBConnect DBC = new DBConnect();
				Connection conn = DBC.getConn();
				PreparedStatement ps = null;
				ResultSet rs = null;
		 				
				try {
					
					String user = ((Account_data)session.getAttribute("account_info")).getName();
					String item_number = request.getParameter("detail");
					String itemQuery = "SELECT * FROM item i, phone_type pt WHERE AND item_num = ? pt.brand = i.brand AND pt.model = i.model";
					ps = conn.prepareStatement(itemQuery);
					ps.addString(item_number);
					rs = ps.executeQuery();
					while (rs.next()) {
					%>
						
						<tr>
						<td><%=rs.getString("title") %></td>
						<td><%=rs.getString("description") %></td>
						<td><%=rs.getString("model") %></td>
						<td><%=rs.getString("os") %></td>
						<td><%=rs.getString("brand") %></td>
						<td><%=rs.getInt("ram") %></td>
						<td><%=rs.getInt("rom") %></td>
						<td><%=rs.getString("cpu_core") %></td>
						<id><%=rs.getInt("start_price") %></id>
						</tr>
						<% 
					}
				} catch (Exception e) {
					e.printStackTrace();
				}				
						%>
		</table>
	</div>
</body>
</html>
