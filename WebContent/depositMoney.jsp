<%@page import="com.epam.models.Account"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	  Account account = (Account) session.getAttribute("view_account");
	%>
	<form action="DepositMoney" method="post">
	Enter Amount <input type="number" name="depositAmount">
	<br>
	<input type="submit" value="submit">
	</form>
</body>
</html>