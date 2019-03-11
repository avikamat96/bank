/**
 * 
 */
package com.epam.services;

import com.epam.dao.AccountDao;
import com.epam.dao.AccountDaoImpl;
import com.epam.exceptions.InsufficientBalanceException;
import com.epam.exceptions.UserAccountNotFoundException;
import com.epam.models.Account;

/**
 *
 * @author Avinash_Kamat
 */
public class TransactionService {

 
  public Account withdrawMoney(long accountNumber, double amount)
      throws UserAccountNotFoundException, InsufficientBalanceException {
    Account account = new Account();
    AccountDao accountDao = new AccountDaoImpl();
    account = accountDao.getAccountDetails(accountNumber);
    Double getCurrentBalance = account.getAccountBalance();
    if (getCurrentBalance - amount >= 0) {
      account.setAccountBalance(getCurrentBalance - amount);
      return account;
    } else {
      throw new InsufficientBalanceException("Insufficient balance");
    }
    

  }

  public Account depositMoney(long accountNumber, double amount) throws UserAccountNotFoundException {
    AccountService accountService = new AccountService();
    Account account = accountService.getAccountDetails(accountNumber);
    account.setAccountBalance(account.getAccountBalance() + amount);
    return account;
  }

}
