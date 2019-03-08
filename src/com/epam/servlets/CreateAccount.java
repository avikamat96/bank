package com.epam.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.enums.AccountType;
import com.epam.enums.Gender;
import com.epam.exceptions.UserInformationNotValidException;
import com.epam.models.Account;
import com.epam.models.Users;
import com.epam.services.AccountDaoImpl;
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
    Gender userGender = request.getParameter("userGender").equals("male") 
        ? Gender.MALE
        : Gender.FEMALE;
    AccountType accountType = request.getParameter("accountType").equals("savings")
        ? AccountType.SAVINGS
        : AccountType.CURRENT;
    Users user = new Users(userName, userAge, userGender);
    AccountDaoImpl accountDao = new AccountDaoImpl();
    AccountValidatorService validatorService = new AccountValidatorService();
    Account account = new Account();
    try {
      if (validatorService.validate(user)) {
        accountDao.createAccount(user, AccountType.SAVINGS, account);
      }
    } catch (UserInformationNotValidException e) {
      response.getWriter().println("Error");
    }

  }

}
