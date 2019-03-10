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
	<form action="" method="post">
		<div class="form-group">
			<label for="name">Name</label> <input type=text
				value="<%=account.getOwner().getName()%>" name="updatedUserName" disabled="disabled" >
		</div>
		<br> <br>
		<div class="form-group">
			<label for="Age">Age</label> <input type=text
				value=<%=account.getOwner().getAge()%> name="updatedUserAge" disabled="disabled">
		</div>
		<br> <br>
		<div class="form-group">
			<label for="Gender">Gender</label> <input type=text
				value=<%=account.getOwner().getGender()%> name="updatedUserGender" disabled="disabled">
		</div>
		<br> <br>
		<div class="form-group">
			<label for="AccountType">Account Type</label> <input type=text
				value=<%=account.getAccountType()%> disabled="disabled"> 
		</div>
		<br> <br>
		<div class="form-group">
			<label for="AccountNumber">Account Number</label> <input type=text
				value=<%=account.getAccountNumber()%> disabled="disabled"> 
		</div>
		<br><br>
		<div class="form-group">
			<label for="AccountBalance">Account Balance</label> <input type=text
				value=<%=account.getAccountBalance()%> disabled="disabled"> 
		</div>
		<br><br>
		<input type="submit" value="Deposit Money" onclick="form.action='depositMoney.jsp';">
		<br><br>
		<input type="submit" value="Withdraw Money" onclick="form.action='withdrawMoney.jsp';">
	</form>
</body>
</html>