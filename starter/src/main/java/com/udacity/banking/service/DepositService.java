package com.udacity.banking.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.udacity.banking.entity.Deposit;
import com.udacity.banking.repository.AccountRepository;
import com.udacity.banking.repository.TransactionRepository;

/**
 * Service for depositing money into an account.
 * 
 * EXERCISE: Implement makeDeposit to atomically:
 *   1. Fetch the account
 *   2. Update its balance (add the deposit amount)
 *   3. Save the account
 *   4. Create and save a Deposit entity (with a description, createdAt, amount, account)
 *   5. Return the saved Deposit
 *
 * The DepositServiceTest verifies the balance is increased by the deposit amount.
 */
@Service
public class DepositService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public DepositService(AccountRepository accountRepository,
                          TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    /**
     * Atomically deposit an amount into an account.
     * 
     * @param accountId the target account ID
     * @param amount the amount to deposit (must be positive)
     * @return the created Deposit entity (with generated ID)
     *
     * TODO: Add @Transactional, then implement the steps in the class Javadoc.
     */
    public Deposit makeDeposit(Long accountId, BigDecimal amount) {
        // TODO: implement this method
        throw new UnsupportedOperationException("Not yet implemented");
    }
}