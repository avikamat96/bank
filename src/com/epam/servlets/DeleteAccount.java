package com.epam.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.exceptions.UserAccountNotFoundException;
import com.epam.models.Account;
import com.epam.services.AccountDaoImpl;

/**
 * Servlet implementation class DeleteAccount
 */
@WebServlet("/DeleteAccount")
public class DeleteAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAccount() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  long accountNumber = Long.parseLong(request.getParameter("accountNumber"));
	  AccountDaoImpl accountDao = new AccountDaoImpl();
	  try {
      accountDao.deleteAccount(accountNumber);
    } catch (UserAccountNotFoundException e) {
      e.printStackTrace();
    }
	}

}
