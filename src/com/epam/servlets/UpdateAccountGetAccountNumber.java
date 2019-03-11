package com.epam.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.dao.AccountDaoImpl;
import com.epam.exceptions.UserAccountNotFoundException;
import com.epam.models.Account;

/**
 * Servlet implementation class UpdateAccount
 */
@WebServlet("/UpdateAccountGetAccountNumber")
public class UpdateAccountGetAccountNumber extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public UpdateAccountGetAccountNumber() {
    super();
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    AccountDaoImpl accountDao = new AccountDaoImpl();
    HttpSession session = request.getSession();
    long accountNumber = Long.parseLong(request.getParameter("accountNumber"));
    try {
      Account account = accountDao.getAccountDetails(accountNumber);
      session.setAttribute("update_account", account);
      request.getRequestDispatcher("updateAccount.jsp").forward(request, response);

    } catch (UserAccountNotFoundException e) {
      response.getWriter().println(e.getMessage());
    }

  }

}
