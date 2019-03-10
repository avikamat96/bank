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
		Account account = (Account) session.getAttribute("account");
	%>
	<form action="" method="post">
		<div class="form-group">
			<label for="name">Name</label>
			<%
				out.println(account.getOwner().getName());
			%>
		</div>
		<br> <br>
		<div class="form-group">
			<label for="Age">Age</label>
			<%
				out.println(account.getOwner().getAge());
			%>
		</div>
		<br> <br>
		<div class="form-group">
			<label for="Gender">Gender</label>
			<%
				out.println(account.getOwner().getGender());
			%>
		</div>
		<br> <br>
		<div class="form-group">
			<label for="AccountType">Account Type</label>
			<%
				out.println(account.getAccountType());
			%>
		</div>
		<br> <br>
		<div class="form-group">
			<label for="AccountNumber">Account Number</label>
			<%
				out.println(account.getAccountNumber());
			%>
		</div>
	</form>
</body>
</html>