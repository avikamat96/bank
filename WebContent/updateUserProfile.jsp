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
	  Account account = (Account) session.getAttribute("update_account");
	%>
	<form action="UpdateAccount" method="post">
		<div class="form-group">
			<label for="name">Name</label> <input type=text
				value="<%=account.getOwner().getName()%>" name="updatedUserName"  >
		</div>
		<br> <br>
		<div class="form-group">
			<label for="Age">Age</label> <input type=text
				value=<%=account.getOwner().getAge()%> name="updatedUserAge">
		</div>
		<br> <br>
		<div class="form-group">
			<label for="Gender">Gender</label> <input type=text
				value=<%=account.getOwner().getGender()%> name="updatedUserGender">
		</div>
		<br> <br>
		<div class="form-group">
			<label for="AccountType">Account Type</label> <input type=text
				value=<%=account.getAccountType()%> disabled="disabled"> <input
				type="hidden" value=<%=account.getAccountType()%>
				name="updatedUserAccountType">
		</div>
		<br> <br>
		<div class="form-group">
			<label for="AccountNumber">Account Number</label> <input type=text
				value=<%=account.getAccountNumber()%> disabled="disabled"> <input
				type="hidden" value=<%=account.getAccountNumber()%>
				name="updatedUserAccountNumber">
		</div>
		<br> <br> <input type="submit" value="submit">
	</form>
</body>
</html>