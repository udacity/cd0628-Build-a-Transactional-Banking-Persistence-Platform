package com.udacity.banking.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.udacity.banking.entity.Transfer;
import com.udacity.banking.exception.InsufficientFundsException;
import com.udacity.banking.repository.AccountRepository;
import com.udacity.banking.repository.TransactionRepository;

/**
 * Service for transferring money between two accounts.
 * 
 * EXERCISE: Implement makeTransfer to atomically:
 *   1. FIRST — record an audit log entry via AuditLogService (so the audit
 *      survives even when the transfer rolls back — this is the REQUIRES_NEW pattern)
 *   2. Fetch source and target accounts
 *   3. Verify source has sufficient balance (throw InsufficientFundsException if not)
 *   4. Decrement source balance, increment target balance
 *   5. Save both accounts
 *   6. Create and save a Transfer entity (links source and target)
 *   7. Return the saved Transfer
 *
 * The TransferServiceTest verifies both source and target balances change atomically.
 * The AuditLogServiceTest verifies the audit row survives even when the transfer
 * rolls back.
 */
@Service
public class TransferService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;
    private final AuditLogService auditLogService;

    public TransferService(AccountRepository accountRepository,
                           TransactionRepository transactionRepository,
                           AuditLogService auditLogService) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
        this.auditLogService = auditLogService;
    }

    /**
     * Atomically transfer an amount from source to target account.
     *
     * @param sourceAccountId account to debit
     * @param targetAccountId account to credit
     * @param amount the amount to transfer (must be positive)
     * @return the created Transfer entity
     * @throws InsufficientFundsException if source has less than amount
     *
     * TODO: Add @Transactional, then implement the steps in the class Javadoc.
     * Hint: Call auditLogService.recordEvent(...) FIRST so the audit row is
     *       committed in its own transaction (REQUIRES_NEW) even if the
     *       transfer later rolls back.
     */
    public Transfer makeTransfer(Long sourceAccountId, Long targetAccountId, BigDecimal amount) {
        // TODO: implement this method
        throw new UnsupportedOperationException("Not yet implemented");
    }
}