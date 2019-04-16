<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="data.List_item_data"%>
<%@ page import="get.Get_item_data"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<%
Get_item_data q = new  Get_item_data(request.getParameter("search"));
ArrayList<List_item_data> result = q.getResult();
%>
<script type="text/javascript">
 window.location.href="index.jsp"
</script>
</body>
</html>