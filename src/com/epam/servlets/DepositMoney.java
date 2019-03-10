package com.epam.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.dao.TransactionDao;
import com.epam.exceptions.UserAccountNotFoundException;
import com.epam.models.Account;
import com.epam.services.AccountDaoImpl;
import com.epam.services.TransactionDaoImpl;

/**
 * Servlet implementation class DepositMoney
 */
@WebServlet("/DepositMoney")
public class DepositMoney extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepositMoney() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  TransactionDaoImpl transactionDao = new TransactionDaoImpl();
      HttpSession session = request.getSession();
      Account account = (Account) session.getAttribute("view_account");
      long accountNumber = account.getAccountNumber();
      try {
        account = transactionDao.depositMoney(accountNumber, Double.parseDouble(request.getParameter("depositAmount")));
        session.setAttribute("view_account", account);
        request.getRequestDispatcher("viewUserProfile.jsp").forward(request, response);

      } catch (UserAccountNotFoundException e) {
         response.getWriter().println(e.getMessage());
      }
	}

}
