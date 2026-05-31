package com.udacity.banking.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.udacity.banking.repository.AccountRepository;

/**
 * Worker class that performs a pessimistic-locked balance update.
 *
 * IMPORTANT — This is a SEPARATE bean from PessimisticLockingDemoService
 * for a reason. Spring's @Transactional only works when methods are called
 * THROUGH the Spring proxy. If addBalanceWithLock were a method on
 * PessimisticLockingDemoService itself, calling it from a lambda inside
 * runTwoThreadDemo would bypass the proxy and the transaction would not start
 * — causing "No active transaction" errors when the locking query runs.
 *
 * EXERCISE: Implement addBalanceWithLock:
 *   1. Use accountRepository.findByIdForUpdate(accountId) to acquire a 
 *      pessimistic write lock on the row (SELECT ... FOR UPDATE)
 *   2. Sleep 2 seconds to make the serialization visible in the demo
 *   3. Add delta to the current balance
 *   4. Save the account
 *
 * No test class for pessimistic locking — concurrent tests are flaky.
 * Verify via the DemoRunner ("demo" profile) — you should see two threads
 * serialize cleanly with FOR UPDATE locks.
 */
@Service
public class AccountUpdateWorker {

    private final AccountRepository accountRepository;

    public AccountUpdateWorker(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    /**
     * Acquire a pessimistic write lock on the account, sleep for 2 seconds,
     * then update the balance by delta.
     *
     * @param accountId the account to lock
     * @param delta the amount to add to the balance
     * @param threadName label for the demo output (e.g. "Thread-A")
     *
     * TODO: Add @Transactional, then implement the steps in the class Javadoc.
     * Hint: accountRepository.findByIdForUpdate(...) is the lock-aware finder
     *       you'll define on AccountRepository (with @Lock(PESSIMISTIC_WRITE)).
     */
    public void addBalanceWithLock(Long accountId, BigDecimal delta, String threadName) {
        // TODO: implement this method
        throw new UnsupportedOperationException("Not yet implemented");
    }
}