# Transactional Banking Persistence Platform

## Project Overview

In this project you will build the **persistence layer** of a small banking platform using **Spring Boot 4, Hibernate 7, and PostgreSQL 17**. You are given the data model (entities + Flyway migrations) and the test suite. Your job is to implement the **repository finders**, **service-layer transactional behavior**, **optimistic and pessimistic locking**, **dynamic queries with Specifications**, and **N+1 query fixes**.

A learner who finishes this project will have hands-on experience with the persistence patterns that real-world Java backend engineers use every day.

**Estimated time to complete: 4–6 hours.**

## Learning Objectives

By the end of this project you will be able to:

- Define Spring Data JPA repositories using derived methods, JPQL `@Query`, native SQL, and `@EntityGraph`
- Apply `@Transactional` to enforce atomicity in multi-step persistence operations
- Use `Propagation.REQUIRES_NEW` to record audit data that survives caller rollbacks
- Implement optimistic locking with `@Version` and detect lost updates
- Implement pessimistic locking with `@Lock(PESSIMISTIC_WRITE)` for serialized writes
- Compose Spring Data **Specifications** to build dynamic, filterable queries
- Identify and fix the **N+1 query problem** using `@BatchSize`, `JOIN FETCH`, and `@EntityGraph`

## Prerequisites

- **JDK 25** (Temurin recommended)
- **Docker Desktop** (for PostgreSQL 17)
- **Git**
- An editor with Java support (VS Code with Java extensions, IntelliJ IDEA, or Eclipse)

## Getting Started

### 1. Clone the repository and enter the starter folder

```bash
git clone <this-repo-url>
cd cd0628-Build-a-Transactional-Banking-Persistence-Platform/starter
```

### 2. Start PostgreSQL

```bash
docker compose up -d
```

This launches PostgreSQL 17 on port `5432` with database `banking`, user `banking`, password `banking`. Flyway will auto-create the schema on first run.

### 3. Verify the starter compiles

```bash
./mvnw compile        # macOS/Linux
./mvnw.cmd compile    # Windows PowerShell
```

You should see `BUILD SUCCESS`.

### 4. Run the tests — they should mostly FAIL

```bash
./mvnw test
```

Expected result: **1 test passes** (the smoke test) and **6 tests fail** with `UnsupportedOperationException: Not yet implemented`. That's your starting point. **Your task is to make all 7 tests pass.**

## What You Will Build

You will fill in the `TODO` markers in these files (in roughly this order):

### Repositories (define the query methods)

1. **`AccountRepository.java`** — derived methods, JPQL `@Query`, JOIN FETCH, constructor projection, and `@Lock(PESSIMISTIC_WRITE)`. The class Javadoc lists the 8 methods to define.

2. **`CustomerRepository.java`** — two finders that demonstrate `JOIN FETCH` and `@EntityGraph`.

3. **`TransactionRepository.java`** — keyset pagination and a native query that returns `MonthlyReport` DTO rows.

4. **`AccountSpecs.java`** — four `Specification<Transaction>` builders used by the dynamic search service.

### Services (implement the transactional behavior)

5. **`DepositService.java`** — atomic balance update + transaction row insert.

6. **`WithdrawalService.java`** — atomic update with insufficient-funds rollback.

7. **`TransferService.java`** — multi-account transaction with audit log call.

8. **`AuditLogService.java`** — `Propagation.REQUIRES_NEW` to commit audit independently.

9. **`OptimisticLockingDemoService.java`** — reproduce a lost-update conflict using `@Version`.

10. **`AccountUpdateWorker.java`** + **`PessimisticLockingDemoService.java`** — two-thread demo with `SELECT ... FOR UPDATE` locking.

11. **`NPlusOneDemoService.java`** — three loaders showing default + `@BatchSize`, `JOIN FETCH`, and `@EntityGraph` approaches.

12. **`TransactionSearchService.java`** — compose specifications conditionally.

13. **`MonthlyReportService.java`** — call the native query and return the DTO list.

Each file has class-level and method-level Javadoc explaining what to implement and why. The hints reference specific Hibernate/Spring annotations and patterns from the course content.

## How to Verify Your Work

Run `./mvnw test` after each change. Your goal is:

Tests run: 7, Failures: 0, Errors: 0, Skipped: 0

The tests are deliberately structured so that:

- **`DepositServiceTest`** passes once `DepositService.makeDeposit` is implemented with `@Transactional`.
- **`WithdrawalServiceTest`** (2 tests) passes when both the success and rollback paths work.
- **`TransferServiceTest`** passes when source and target balances change atomically.
- **`AuditLogServiceTest`** passes only if your `AuditLogService.recordEvent` uses `Propagation.REQUIRES_NEW`. The test forces an `InsufficientFundsException` rollback and verifies the audit row count still went up by 1.
- **`OptimisticLockingDemoServiceTest`** passes when your code raises `OptimisticLockingFailureException` from a stale-version save.
- **`BankingApplicationTests`** passes as soon as the Spring context boots (it's a smoke test).

You can also verify by inspecting the `target/surefire-reports/` directory after each test run.

## Acceptance Criteria

A complete submission satisfies all of the following:

| # | Criterion |
|---|-----------|
| 1 | `./mvnw compile` succeeds with no errors |
| 2 | `./mvnw test` reports `Tests run: 7, Failures: 0, Errors: 0` |
| 3 | `AccountRepository` defines all 8 methods with appropriate annotations |
| 4 | `CustomerRepository` has both `findAllWithJoinFetch` (JPQL) and `findAllWithEntityGraph` (`@EntityGraph`) |
| 5 | `TransactionRepository` has keyset-pagination method AND a native-query method for the monthly report |
| 6 | All four service-layer write methods (deposit, withdrawal, transfer, audit) use `@Transactional` correctly — including `REQUIRES_NEW` on audit |
| 7 | `OptimisticLockingDemoService` detaches the first entity before loading the second, and triggers `OptimisticLockingFailureException` |
| 8 | `AccountUpdateWorker.addBalanceWithLock` calls `findByIdForUpdate` and is `@Transactional` |
| 9 | `AccountSpecs` builders correctly use `CriteriaBuilder` to construct predicates |

## Troubleshooting

- **`Connection refused` to Postgres** → `docker compose ps` to check the container is up; `docker compose logs db` to inspect.
- **`LazyInitializationException: could not initialize proxy`** → you're accessing a lazy collection outside a transaction. Add `@Transactional` to the method, or use `JOIN FETCH` / `@EntityGraph`.
- **`No active transaction` on a pessimistic lock query** → the method must be `@Transactional` AND called through the Spring proxy (not via self-invocation). This is why `AccountUpdateWorker` is a separate bean.
- **`OptimisticLockingFailureException` not thrown in the demo** → you forgot `entityManager.detach(clientA)` before loading Client B. Without detach, Hibernate's first-level cache returns the same instance both times.

## Built With

- **Spring Boot 4.0.6** — application framework
- **Hibernate ORM 7.2** — JPA provider
- **PostgreSQL 17** — relational database
- **Flyway** — database migrations
- **Maven** (via wrapper) — build tool
- **JUnit 5** — testing framework
- **Docker Compose** — local Postgres orchestration

## License

See `LICENSE.txt` in the repository root.

