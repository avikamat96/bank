<%@page import="java.util.List"%>
<%@page import="com.epam.models.Account"%>
<%@page import="com.epam.services.AccountDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% AccountDaoImpl accountDao = new AccountDaoImpl();
List<Account> accountList =  accountDao.getAllAccounts(); %>
<table style="width:50%" border=1>
  <tr>
    <th>AccountNumber</th>
    <th>Name</th> 
    <th>Age</th>
    <th>Gender</th>
    <th>Account Type</th>
  </tr>
  <% 
  for(Account account : accountList){ %>
    
  <tr>
   <td><%= account.getAccountNumber() %></td> 
   <td><%= account.getOwner().getName() %></td> 
   <td><%= account.getOwner().getAge() %></td> 
   <td><%= account.getOwner().getGender() %></td> 
   <td><%= account.getAccountType() %></td> 
  </tr>
 <% }
  %>
  </table>
</body>
</html>