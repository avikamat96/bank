package com.epam.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public Login() {
    super();
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    long accountNumber = Long.parseLong(request.getParameter("Account Number"));
    String password = request.getParameter("Account Password");
    if (accountNumber == 1111 && password.equals("1111")) {
      RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
      dispatcher.forward(request, response);
    }
    else {
      request.getRequestDispatcher("loginAlert.jsp").forward(request, response);
    }
  }

}
