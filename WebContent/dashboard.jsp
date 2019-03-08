<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Dashboard" method="post">
<input type="submit" value="Create Account" onclick="form.action='createAccount.jsp';">
<br><br>
<input type="submit" value="Update Account" onclick="form.action='updateAccount.jsp';">
<br><br>
<input type="submit" value="Find Account Details" onclick="form.action='accountDetails.jsp';">
<br><br>
<input type="submit" value="Show All Account" onclick="form.action='listAllAccounts.jsp';">
<br><br>
<input type="submit" value="Delete Account" onclick="form.action='deleteAccount.jsp';">
</form>
</body>
</html>