package com.udacity.banking.service;

import org.springframework.stereotype.Service;

import com.udacity.banking.repository.AccountRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * Demonstrates optimistic locking using @Version on the Account entity.
 *
 * EXERCISE: Implement simulateConflict to reproduce a lost-update conflict:
 *   1. Load the account as "Client A" (capture initial version)
 *   2. Detach Client A's entity from the persistence context (entityManager.detach)
 *      — this forces the next find to return a fresh object, not the cached one
 *   3. Load the account as "Client B" (also at the initial version)
 *   4. Modify and save Client B's entity — this increments the version in the DB
 *   5. Modify and save Client A's entity — this should fail because Client A
 *      is holding a stale version; Hibernate throws OptimisticLockingFailureException
 *
 * The OptimisticLockingDemoServiceTest verifies the expected exception is thrown.
 */
@Service
public class OptimisticLockingDemoService {

    private final AccountRepository accountRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public OptimisticLockingDemoService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    /**
     * Simulate two clients updating the same account concurrently to trigger
     * optimistic locking. Expected to throw OptimisticLockingFailureException
     * on the second save (the one with the stale version).
     *
     * @param accountId the account to test against
     *
     * TODO: Implement the steps from the class Javadoc.
     * Hint: Use entityManager.detach(clientA) BEFORE loading Client B,
     *       otherwise Hibernate returns the SAME cached instance and the
     *       demo doesn't work.
     */
    public void simulateConflict(Long accountId) {
        // TODO: implement this method
        throw new UnsupportedOperationException("Not yet implemented");
    }
}