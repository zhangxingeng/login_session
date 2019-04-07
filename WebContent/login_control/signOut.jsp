<%
session.removeAttribute("userSession");
session.setAttribute("loginMessage", "Sign out Successfull");
%>
<script type="text/javascript">
	window.location.href="./home.jsp";
</script>