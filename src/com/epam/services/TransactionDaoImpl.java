/**
 * 
 */
package com.epam.services;

import com.epam.dao.AccountDao;
import com.epam.dao.TransactionDao;
import com.epam.exceptions.InsufficientBalanceException;
import com.epam.exceptions.UserAccountNotFoundException;
import com.epam.models.Account;

/**
 * The Class TransactionDaoMockImpl.
 *
 * @author Avinash_Kamat
 */
public class TransactionDaoImpl implements TransactionDao {

  /*
   * (non-Javadoc)
   * 
   * @see com.epam.rd.dao.TransactionDao#withdrawMoney(long, double)
   */
  @Override
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

  /*
   * (non-Javadoc)
   * 
   * @see com.epam.rd.dao.TransactionDao#depositMoney(long, double)
   */
  @Override
  public Account depositMoney(long accountNumber, double amount) throws UserAccountNotFoundException {
    Account account = new Account();
    AccountDao accountDao = new AccountDaoImpl();
    account = accountDao.getAccountDetails(accountNumber);
    account.setAccountBalance(account.getAccountBalance() + amount);
    return account;
  }

}
