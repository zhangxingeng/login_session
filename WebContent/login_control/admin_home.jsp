<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="data.Login_data"%>

<html>
<head>
<title>BuyMe_Admin_Home</title>
</head>
<body>
	<h2>Create a Customer Rep</h2>
	<form action="Create a Rep button" method="post">
		<input type="text" name="email" placeholder="Email"> 
		<br>
		<input type="text" name="password" placeholder="Password"> 
		<br>
		
		<button type="submit" name="button" value="CR">Submit</button>
	</form>
	<br>
	<br>
	<h2> Delete a regular account</h2>
	<form action="Delete account" method="post">
		<input type="text" name="email" placeholder="Email"> 
		<br>
		<button type="submit" name="button" value="delAcc">Submit</button>

	</form>




	<%-- The sales report section --%>
	<br>
	<br>
	<br>
	<h3>Sales Reports</h3>
	<form action="SalesReport" method="post">

	    <input type= "radio" name = "rtype" value = "TotEarn">Total Earnings
	    <br>
	    <input type= "radio" name = "rtype" value = "EpItem">Earnings per item
	    <br>
	    <input type= "radio" name = "rtype" value = "EpItemType">Earnings per item type
	    <br>
	    <input type= "radio" name = "rtype" value = "EpEndUser">Earnings per end-user
	    <br>
	    <input type= "radio" name = "rtype" value = "BSitems">Best-Selling Items
	    <br>
	    <input type= "radio" name = "rtype" value = "BBuyers">Best Buyers 
	    <br>

	    <input type="submit" value=Submit>

	</form>

</body>
</html>