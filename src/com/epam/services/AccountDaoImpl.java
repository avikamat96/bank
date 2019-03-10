/**
 * 
 */
package com.epam.services;

import java.util.ArrayList;
import java.util.List;

import com.epam.dao.AccountDao;
import com.epam.enums.AccountType;
import com.epam.exceptions.UserAccountNotFoundException;
import com.epam.models.Account;
import com.epam.models.Users;

/**
 * @author Avinash_Kamat
 *
 */
public class AccountDaoImpl implements AccountDao {

  private static List<Account> accountList = new ArrayList<Account>();

  @Override
  public Account createAccount(Users user, AccountType accountType) {
    long userAccountNumber = GenerateAccountNumber.generateAccountNumber();
    Account account = new Account();
    account.setAccountType(accountType);
    account.setAccountNumber(userAccountNumber);
    account.setOwner(user);
    account.setAccountBalance(0.00);
    accountList.add(account);
    return account;
  }

  @Override
  public void deleteAccount(long accountNumber) throws UserAccountNotFoundException {
    for (Account account : accountList) {
      if (account.getAccountNumber() == (accountNumber)) {
        //accountList.remove(account);
        account.setAccountType(AccountType.DISABLED);
      }
    }
    throw new UserAccountNotFoundException("Account number does not exist");
  }

  @Override
  public void updateAccount(long accountNumber, Account account) throws UserAccountNotFoundException {
    for (Account tempAccount : accountList) {
      if (tempAccount.getAccountNumber() == accountNumber) {
        accountList.remove(tempAccount);
        accountList.add(account);
        return;
      }
    }
    throw new UserAccountNotFoundException("Account number does not exist");
  }

  @Override
  public Account getAccountDetails(long accountNumber) throws UserAccountNotFoundException {
    for (Account account : accountList) {
      if (account.getAccountNumber() == (accountNumber)) {
        return account;
      }
    }
    throw new UserAccountNotFoundException("Account number does not exist");

  }

  @Override
  public List<Account> getAllAccounts() {
    return accountList;
  }
}
