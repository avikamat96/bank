/**
 * 
 */
package com.epam.dao;

import com.epam.exceptions.InsufficientBalanceException;
import com.epam.exceptions.UserAccountNotFoundException;

/**
 * The Interface TransactionDao.
 *
 * @author Avinash_Kamat
 * @param <T>
 */
public interface TransactionDao {

  /**
   * Withdraw money.
   *
   * @param accountNumber the account number
   * @param amount        the amount
   * @throws UserAccountNotFoundException the user account not found exception
   * @throws InsufficientBalanceException the insufficient balance exception
   */
  <T> T withdrawMoney(long accountNumber, double amount)
      throws UserAccountNotFoundException, InsufficientBalanceException;

  /**
   * Deposit money.
   *
   * @param accountNumber the account number
   * @param amount        the amount
   * @throws UserAccountNotFoundException the user account not found exception
   */
  <T> T depositMoney(long accountNumber, double amount) throws UserAccountNotFoundException;
}
