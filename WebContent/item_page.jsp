<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="data.List_item_data"%>
<%@ page import="data.Account_data"%>
<%@ page import="connect.DBConnect"%>
<%@page import="java.sql.*"%>
<%@page import="javax.servlet.*"%>
<%@page import="data.List_answer_data"%>
<%@page import="data.List_question_data"%>
<%@page import="data.Account_data"%>



<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>BuyMe Item</title>
	</head>
<body>
    <h1 class="content center big">Item Page</h1>

    <div class="Item Info">
        

        
        
        <%
				DBConnect DBC = new DBConnect();
				Connection conn = DBC.getConn();
				PreparedStatement ps = null;
				ResultSet rs = null;
		%>
		
		<table align="center" cellpadding="5" cellspacing="5" border="1">
		<tr></tr>
		<tr>
		<td><b>Title</b></td>
		<td><b>Description</b></td>
		<td><b>Brand</b></td>
		
		<td><b>Model</b></td>
		<td><b>RAM</b></td>
		<td><b>ROM</b></td>
		<td><b>OS</b></td>
		<td><b>Starting Price</b></td>
		<td><b>Tiem Left</b></td>
		</tr>
        
		
        
        <%
		
				DBConnect DBC = new DBConnect();
				Connection conn = DBC.getConn();
				PreparedStatement ps = null;
				ResultSet rs = null;
		 		
				Account_data curr_user = (Account_data)(session.getAttribute("account_info"));
				
				try {
					
					String user = curr_user.getName();
					String item_num = request.getParameter("detail");
					String itemQuery = "SELECT * FROM item i, phone_type pt WHERE AND item_num = ? pt.brand = i.brand AND pt.model = i.model";
					ps = conn.prepareStatement(itemQuery);
					ps.addString(item_num);
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
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}				
						%>
		</table>
	
	
	<% //QUESITONA DN ANSWERS FOR THE ITEM %>
	</div>
	<div class="Questiona and Answers">
	
		<h2>Question and Anwers</h2>
			<table border="1">
				<tr>
				<td>Question</td>
				<td>Answer</td>
				</tr>
        
        		<%
        		List_question_data quest = (List_question_data)(session.getAttribute("List_question_info"));
        		List_answer_data ans = (List_answer_data)(session.getAttribute("List_answer_info"));
        		try{
        			String q_quest_num = quest.getQuestion_num();
        			String q_item_num = quest.getItem_num();
        			String a_quest_num = ans.getQuestion_num();
        			String item_num = request.getParameter("detail");
        			
        			String q_and_a_query = "select q.question, a.answer from item i, question q, answer a whwre i.item_num = ? AND (i.item_num = q.item_num AND (q.question_num = a.question_num))"; 
        			ps = conn.prepareStatement(q_and_a_query);
					rs = ps.executeQuery();
					while(rs.next()){
						%>
						
						<tr>
						<td><%=rs.getString("question") %></td>
						<td><%=rs.getString("answer") %></td>
						</tr>
						
						<% 
					}
					conn.close();
        		} catch (Exception e) {
        			e.printStackTrace();
        		}
        		
        		%>
        
        </table>
	
	</div>
	
	<% //BID FOR THIS ITEM %>
	<div>
		<h1>Bid Information:</h1>
		
		<%
		try{
			String bid_count_query = "SELECT count(*) FROM bids b, item i WHERE i.item_num = ? ADN ? = b.item_num";
			ps = conn.prepareStatement(bid_count_query);
			rs = ps.executeQuery();	
			String count="";
			while(rs.next()){
				count = rs.getString(1);
				out.println("Total Number of Bids: " +count);
			} 
			conn.close();
		}catch (Exception e){
			e.printStackTrace();
		}
		%>
	
		<%
		try{
			String curr_price_query = "SELECT MAX(price) FROM bids WHERE ";
			ps = conn.prepareStatement(curr_price_query);
			rs = ps.executeQuery();
			while(rs.next()){
				%>
				current price <label><%=rs.getString("price")%></label>
				<%
			} 
			conn.close();
		}catch (Exception e){
			e.printStackTrace();
		}
		%>
		<form action="Place_bid_handler" method="POST">
			Place Your Bid <input type="number"></input>
			<input type="submit" value="Submit">
		</form>
	</div>

	<div class="actions">
		<button onclick="set_alert.java">Set Alert</button>
		<button onclick="add_to_watch_list.java">Add to watch list</button>
	</div>
</body>
</html>
