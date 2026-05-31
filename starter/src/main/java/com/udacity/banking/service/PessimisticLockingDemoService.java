package com.udacity.banking.service;

import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

/**
 * Orchestrates a two-thread pessimistic locking demo.
 *
 * EXERCISE: Implement runTwoThreadDemo:
 *   1. Create a 2-thread ExecutorService
 *   2. Submit two CompletableFuture.runAsync calls — each calling
 *      accountUpdateWorker.addBalanceWithLock(accountId, BigDecimal("100"), "Thread-X")
 *   3. Wait for both with CompletableFuture.allOf(...).get()
 *   4. Shut down the executor
 *
 * Why is the work delegated to AccountUpdateWorker (a separate bean)?
 * Because Spring's @Transactional only fires when methods are called THROUGH
 * the proxy. A self-call from this class's lambda would bypass the proxy and
 * the lock query would fail with "No active transaction." See the
 * AccountUpdateWorker class Javadoc for details.
 *
 * Verify via the DemoRunner ("demo" profile). Expected:
 *   - Two SELECT ... FOR NO KEY UPDATE queries fire ~simultaneously
 *   - Thread B blocks until Thread A releases the lock
 *   - Final balance is starting + 200 (both 100-increments landed)
 */
@Service
public class PessimisticLockingDemoService {

    private final AccountUpdateWorker accountUpdateWorker;

    public PessimisticLockingDemoService(AccountUpdateWorker accountUpdateWorker) {
        this.accountUpdateWorker = accountUpdateWorker;
    }

    /**
     * Fire two threads that each try to lock and update the same account.
     *
     * @param accountId the account to contend over
     * @throws ExecutionException if either thread fails
     * @throws InterruptedException if the wait is interrupted
     *
     * TODO: Implement the steps in the class Javadoc.
     */
    public void runTwoThreadDemo(Long accountId) throws ExecutionException, InterruptedException {
        // TODO: implement this method
        throw new UnsupportedOperationException("Not yet implemented");
    }
}