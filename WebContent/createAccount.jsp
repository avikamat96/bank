<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="CreateAccount" method="post">
  <div class="form-group" >
    <label for="name">Enter Name</label>
    <input type="text" class="form-control" name="userName">
  </div>
  <br><br>
  <div class="form-group">
    <label for="Age">Enter Age</label>
    <input type="number" class="form-control" name="userAge">
  </div>
  <br><br>
  <div class="form-group">
    <label for="Gender">Enter Gender</label>
    <input type="text" class="form-control" name="userGender">
  </div>
  <br><br>
  <div class="form-group">
    <label for="AccountType">Enter Account Type</label>
    <input type="text" class="form-control" name="accountType">
  </div>
  <br><br>
  <button type="submit" class="btn btn-default">Submit</button>
</form>
</body>
</html>