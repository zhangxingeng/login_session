<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="data.List_item_data"%>
<%@ page import="data.Account_data"%>
<%@ page import="connect.DBConnect"%>
<%@page import="java.sql.*"%>
<%@page import="javax.servlet.*"%>
<%@page import="data.List_answer_data"%>
<%@page import="data.List_question_data"%>
<%@page import="data.Account_data"%>
<%@page import="java.util.*"%>
<%@page import="java.util.Collections"%>


<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>BuyMe Item</title>
	</head>
	<body>
		<h1>Item Page</h1>
		<div>
   <% 
   DBConnect DBC = new DBConnect();
Connection conn = DBC.getConn();
PreparedStatement ps = null;
ResultSet rs = null;

int item_num = Integer.parseInt(request.getParameter("item_num"));
String query = "SELECT * FROM item i, phone_type t WHERE i.item_num = ? AND t.brand = i.brand AND t.model = i.model";
ps = conn.prepareStatement(query);
ps.setInt(1, item_num);

rs = ps.executeQuery();
if(rs.next()){
	out.println("Title: "+(rs.getString("title"))+"<br>");
	out.println("Description: "+(rs.getString("description"))+"<br>");
	out.println("Brand: "+(rs.getString("brand"))+"<br>");
	out.println("Model: "+(rs.getString("model"))+"<br>");
	out.println("Status: "+(rs.getString("status"))+"<br>");
	out.println("Start_price: "+(rs.getFloat("start_price"))+"<br>");
	out.println("Ram: "+(rs.getInt("ram"))+"<br>");
	out.println("Rom: "+(rs.getInt("rom"))+"<br>");
	out.println("Cpu_core: "+(rs.getInt("cpu_core"))+"<br>");
	out.println("Os: "+(rs.getString("os"))+"<br>");
	out.println("Email: "+rs.getString("email")+"<br>");
	
	String bid_count_query = "SELECT count(*) FROM bids b, item i WHERE i.item_num = b.item_num = ?";
	ps = conn.prepareStatement(bid_count_query);
	ps.setInt(1, item_num);
	rs = ps.executeQuery();
	int bid_amount = 0;
	if(rs.next()) {
		bid_amount = rs.getInt(1);
	}else bid_amount = -1;
	
	float curr_price = 0;
	String curr_price_query = "SELECT MAX(price) FROM bids WHERE item_num = ?";
	ps = conn.prepareStatement(curr_price_query);
	ps.setInt(1, item_num);
	rs = ps.executeQuery();
	if(rs.next()) {
		curr_price = rs.getFloat(1);
	}else curr_price = -1;

	
	out.println("Curr_price"+(curr_price)+"<br>");
	out.println("setBid_count"+(bid_amount)+"<br>");
}

			try {if(conn != null) {conn.close();}} 
			catch (Exception e4) {System.out.println("Problem occured at 2!");}
%>
		</div>

		<div>
			<h1>Bid Information:</h1>
			<form action="Bid_handler2" method="POST">
				Place Your Bid :$
				<input type="text" name="bid_price"></input>
				<input type="submit" value="Submit">
			</form>
		</div>
	
		<div class="actions">
			<form name="_alert" action="_alert_handler?item_num=<%=item_num%>" method="post">
			<input type="submit" value="_alert">
			</form>
			<form name="watchlist" action="Add_to_watchlist_handler?item_num=<%=item_num%>" method="post">
			<input type="submit" value="watchlist">
			</form>
		</div>
	</body>
</html>
