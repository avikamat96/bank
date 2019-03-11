package com.epam.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.dao.AccountDaoImpl;
import com.epam.exceptions.UserAccountNotFoundException;
import com.epam.services.AccountService;

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
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      long accountNumber = Long.parseLong(request.getParameter("accountNumber"));
      AccountService accountService = new AccountService();
      accountService.deleteAccount(accountNumber);
    } catch (UserAccountNotFoundException e) {
      response.getWriter().println(e.getMessage());
    }

  }

}
