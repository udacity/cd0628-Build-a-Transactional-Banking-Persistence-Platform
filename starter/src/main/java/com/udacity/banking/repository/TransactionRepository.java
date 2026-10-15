package com.udacity.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.udacity.banking.entity.Transaction;

/**
 * Repository for Transaction entities. Demonstrates pagination patterns,
 * native queries, and dynamic Specifications.
 *
 * EXERCISE: Add these custom finder methods:
 *
 *   1. findNextPageById(Long lastSeenId, Pageable pageable) -> List<Transaction>
 *      Keyset pagination — use @Query JPQL with WHERE t.id > :lastSeenId ORDER BY t.id ASC.
 *      The Pageable controls page size; the lastSeenId controls "where to resume."
 *
 *   2. A native-query method returning MonthlyReport DTOs
 *      Use @Query(value = "...", nativeQuery = true) with PostgreSQL date_trunc 
 *      to compute per-month counts and totals.
 *      To map the rows, either:
 *        a) make MonthlyReport an interface with getMonth(), getTransactionCount()
 *           and getTotalAmount(). Interface projections bind straight to the SQL
 *           aliases and need no further mapping; or
 *        b) keep MonthlyReport as a class and use the @SqlResultSetMapping on
 *           Transaction. A mapping only takes effect when a query references it
 *           by name, so this route also needs @NamedNativeQuery(name =
 *           "Transaction.getMonthlyReport", resultSetMapping =
 *           "MonthlyReportMapping") on the entity. A class DTO on a plain
 *           @Query(nativeQuery = true) throws ConverterNotFoundException.
 *
 * The repository also extends JpaSpecificationExecutor<Transaction> for the
 * dynamic search in TransactionSearchService.
 *
 * Offset pagination (page 0 size 10) uses the inherited findAll(Pageable) — no
 * custom method needed.
 */
public interface TransactionRepository extends JpaRepository<Transaction, Long>,
                                                JpaSpecificationExecutor<Transaction> {

    // TODO: Define findNextPageById and the native-query monthly report method.

}