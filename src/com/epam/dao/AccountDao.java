/**
 * 
 */
package com.epam.dao;

import java.util.List;

import com.epam.enums.AccountType;
import com.epam.exceptions.UserAccountNotFoundException;
import com.epam.models.Account;
import com.epam.models.Users;

/**
 * The Interface AccountDao.
 *
 * @author Avinash_Kamat
 * @param <T>
 */
public interface AccountDao {

  /**
   * Creates the account.
 * @param <T>
   *
   * @param user    the user
   * @param savings the savings
   * @param account the account
   */
  <T> T createAccount(Users user, AccountType accountType);

  /**
   * Delete account.
   *
   * @param accountNumber the account number
   * @return true, if successful
   * @throws UserAccountNotFoundException the user account not found exception
   */
  void deleteAccount(long accountNumber) throws UserAccountNotFoundException;

  /**
   * Update account.
   *
   * @param accountNumber the account number
   * @param account       the account
   * @throws UserAccountNotFoundException the user account not found exception
   */
  void updateAccount(long accountNumber, Account account) throws UserAccountNotFoundException;

  /**
   * Gets the account details.
   *
   * @param accountNumber the account number
   * @return the account details
   * @throws UserAccountNotFoundException the user account not found exception
   */
  Account getAccountDetails(long accountNumber) throws UserAccountNotFoundException;
  
   List<Account> getAllAccounts();

}
