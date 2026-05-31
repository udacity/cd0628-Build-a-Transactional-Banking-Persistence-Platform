package com.udacity.banking.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.udacity.banking.entity.Withdrawal;
import com.udacity.banking.exception.InsufficientFundsException;
import com.udacity.banking.repository.AccountRepository;
import com.udacity.banking.repository.TransactionRepository;

/**
 * Service for withdrawing money from an account.
 * 
 * EXERCISE: Implement makeWithdrawal to atomically:
 *   1. Fetch the account
 *   2. Verify the balance is sufficient (if not, throw InsufficientFundsException — this triggers rollback)
 *   3. Update the balance (subtract the withdrawal amount)
 *   4. Save the account
 *   5. Create and save a Withdrawal entity
 *   6. Return the saved Withdrawal
 *
 * The WithdrawalServiceTest verifies both the success path and that an
 * over-withdrawal throws AND leaves the balance unchanged (rollback).
 */
@Service
public class WithdrawalService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public WithdrawalService(AccountRepository accountRepository,
                             TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    /**
     * Atomically withdraw an amount from an account.
     * 
     * @param accountId the source account ID
     * @param amount the amount to withdraw (must be positive)
     * @return the created Withdrawal entity
     * @throws InsufficientFundsException if account balance is less than amount
     *
     * TODO: Add @Transactional, then implement the steps in the class Javadoc.
     * Hint: InsufficientFundsException is a RuntimeException — throwing it
     *       automatically triggers Spring transaction rollback.
     */
    public Withdrawal makeWithdrawal(Long accountId, BigDecimal amount) {
        // TODO: implement this method
        throw new UnsupportedOperationException("Not yet implemented");
    }
}