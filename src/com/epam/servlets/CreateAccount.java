package com.epam.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.enums.AccountType;
import com.epam.enums.Gender;
import com.epam.exceptions.UserInformationNotValidException;
import com.epam.models.Account;
import com.epam.models.Users;
import com.epam.services.AccountService;
import com.epam.services.AccountValidatorService;

/**
 * Servlet implementation class CreateAccount
 */
@WebServlet("/CreateAccount")
public class CreateAccount extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public CreateAccount() {
    super();
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String userName = request.getParameter("userName");
    int userAge = Integer.parseInt(request.getParameter("userAge"));
    Gender userGender = request.getParameter("userGender").toLowerCase().equals("male")
        ? Gender.MALE
        : Gender.FEMALE;
    AccountType accountType = request.getParameter("accountType").toLowerCase().equals("savings")
        ? AccountType.SAVINGS
        : AccountType.CURRENT;
    Users user = new Users(userName, userAge, userGender);
    HttpSession session = request.getSession();
    AccountService accountService = new AccountService();
    AccountValidatorService validatorService = new AccountValidatorService();
    try {
      if (validatorService.validate(user)) {
        Account account = accountService.createAccount(user, accountType);
        session.setAttribute("account", account);
        request.getRequestDispatcher("showProfile.jsp").forward(request, response);
      }
    } catch (UserInformationNotValidException e) {
      response.getWriter().println(e.getMessage());
    }

  }

}
