/**
 * 
 */
package com.epam.services;

import java.util.List;

import com.epam.dao.AccountDaoImpl;
import com.epam.enums.AccountType;
import com.epam.exceptions.UserAccountNotFoundException;
import com.epam.models.Account;
import com.epam.models.Users;

/**
 * @author Avinash_Kamat
 *
 */
public class AccountService {

  public Account createAccount(Users user, AccountType accountType) {
    AccountDaoImpl accountDao = new AccountDaoImpl();
    long userAccountNumber = GenerateAccountNumber.generateAccountNumber();
    Account account = new Account();
    account.setAccountType(accountType);
    account.setAccountNumber(userAccountNumber);
    account.setOwner(user);
    account.setAccountBalance(0.00);
    accountDao.saveAccount(account);
    return account;
  }

  public void deleteAccount(long accountNumber) throws UserAccountNotFoundException{
    AccountDaoImpl accountDao = new AccountDaoImpl();
    Account account = accountDao.getAccountDetails(accountNumber);
    accountDao.removeAccount(account);
  }
  
  public void updateAccount(long accountNumber, Account account)
      throws UserAccountNotFoundException {
    AccountDaoImpl accountDao = new AccountDaoImpl();
    accountDao.updateAccount(accountNumber,account);
  }
  
  public Account getAccountDetails(long accountNumber) throws UserAccountNotFoundException {
       AccountDaoImpl accountDao = new AccountDaoImpl();
       return accountDao.getAccountDetails(accountNumber);
  }

}
