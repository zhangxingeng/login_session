<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>BuyMe_Home</title>
</head>

<body>
	<div class="account">
		<%
if(session.getAttribute("account_info") != null){
%>
		<h5>
			Hello,<%= ((Account_data)session.getAttribute("account_info")).getType() %>!
		</h5>
		<button onclick="logout_handler">logout</button>
		<button onclick="item_upload">upload new items</button>
		<%
}else{
%>
		<form action="Login_handler">
			<h5>Log in</h5>
			<input type="radio" name="identity" value="user">user <input
				type="radio" name="identity" value="staff">staff <input
				type="radio" name="identity" value="admin">admin
			<div>
				Username <input type="text" name="username" > <br>
				Password <input type="password" name="password" ><br>
				<input type="submit" value="Submit">
			</div>
		</form>
		<button onclick="register.jsp">register</button>
		<%
}
%>
	</div>



<%
if( ((Account_data)session.getAttribute("account_info")).getType() != null){
%>
	<div class="email">
		<h2>Message Inbox</h2>
		<table border="1">
			<tr>
			<td>From</td>
			<td>Message</td>
			</tr>
<%
	Account_data curr_user = (Account_data)(session.getAttribute("account_info"));
	String curr_email = curr_user.getEmail();

	DBConnect DBC = new DBConnect();
	Connection conn = DBC.getConn();
	PreparedStatement ps = null;
	ResultSet rs = null;

	try{
		String email_query = "SELECT e.from_email e.message FROM Email e, Account a WHERE e.to_email = a.email";
		ps = conn.prepareStatement(email_query);
		rs = ps.executeQuery();
		while(rs.next()){
			%>

			<tr>
			<td><%=rs.getString("from_email") %></td>
			<td><%=rs.getString("message") %></td>
			</tr>

			<%
		}
		conn.close();
	}catch (Exception e){
		e.printStackTrace();
	}
%>

		</table>

	</div>
<%
}
%>

	<div class="search">
		<form action="Search_handler.jsp" method="post">
			keyword:<input type="text" name="keyword"><br>
			brand:
			<select>
				<option value="apple">Apple</option>
				<option value="samsung">Samsung</option>
				<option value="google">google</option>
				<option value="sony">Sony</option>
				<option value="huawei">Huawei</option>
				<option value="other">Other</option>
			</select><br>
			model<input type="text" name="model"><br>
			min_price<input type="text" name="min_price"><br>
			max_price<input type="text" name="max_price"><br>
			<input type="radio" name="status" value="active">active item<br>
			<input type="radio" name="status" value="history">history item<br>
			<button type="submit">Submit</button>
		</form>
	</div>

	<div class="item_list">
		<table>
			<c:forEach items="${search_result}" var="item">
				<tr>
				    <td>email: ${item.getEmail()}</td>
					<td>title: ${item.getTitle()}</td>
					<td>description: ${item.getDescription}</td>
					<td>status: ${item.getStatus}</td>
					<td>start_price: ${item.getStart_price}</td>
					<td>date: ${item.getDate()}</td>
					<td>item_bidamount: ${item.getItem_bidamount()}</td>
					<td>item_num: ${item.getItem_num()}</td>
					<td>brand: ${item.getBrand()}</td>
					<td>model: ${item.getModel()}</td>
					<td>ram: ${item.getRam()}</td>
					<td>rom: ${item.getRom()}</td>
					<td>os: ${item.getOs()}</td>
					<td>curr_price: ${item.getCurr_price()}</td>
					<td>
						<button onclick="item_detail.jsp?id=${item.getItem_num()}" name="submit" value="${item.getItem_num()}">view</button>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>
