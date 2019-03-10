package com.epam.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.enums.AccountType;
import com.epam.enums.Gender;
import com.epam.exceptions.UserAccountNotFoundException;
import com.epam.models.Account;
import com.epam.models.Users;
import com.epam.services.AccountDaoImpl;

/**
 * Servlet implementation class UpdateAccount
 */
@WebServlet("/UpdateAccount")
public class UpdateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAccount() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String userName = request.getParameter("updatedUserName");
	    int userAge = Integer.parseInt(request.getParameter("updatedUserAge"));
	    Gender userGender = Gender.valueOf(request.getParameter("updatedUserGender").toUpperCase());
	    AccountType accountType = AccountType.valueOf(request.getParameter("updatedUserAccountType").toUpperCase());
	    long accountNumber = Long.parseLong(request.getParameter("updatedUserAccountNumber"));
	    Users user = new Users(userName,userAge,userGender);
	    Account account = new Account();
	    account.setOwner(user);
	    account.setAccountType(accountType);
	    account.setAccountNumber(accountNumber);
	    AccountDaoImpl accountDao = new AccountDaoImpl();
	    try {
        accountDao.updateAccount(accountNumber, account);
      } catch (UserAccountNotFoundException e) {
        e.printStackTrace();
      }
	    
	}

}
