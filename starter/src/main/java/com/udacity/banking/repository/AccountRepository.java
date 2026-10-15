package com.udacity.banking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.udacity.banking.dto.AccountSummary;
import com.udacity.banking.entity.Account;
import com.udacity.banking.entity.Money;

/**
 * Repository for Account entities. Demonstrates Spring Data JPA mechanisms:
 * derived methods, @Query JPQL, JOIN FETCH, projection, and pessimistic locking.
 *
 * EXERCISE: Define the following finder methods on this interface:
 *
 *   1. findAccountsByCustomerEmail(String email) -> List<Account>
 *      Use @Query with JPQL JOIN on Customer to filter by email.
 *
 *   2. getTotalBalanceForCustomer(Long customerId) -> BigDecimal
 *      Use @Query JPQL: SUM(a.balance) WHERE customer.id = :customerId
 *      Money is mapped through MoneyConverter, not @Embeddable, so there is
 *      no .amount path to navigate. Consider COALESCE so a customer with no
 *      accounts returns 0 rather than null.
 * 
 *   3. findByIdWithCustomer(Long id) -> Optional<Account>
 *      Use @Query with JOIN FETCH so the customer is loaded eagerly in one query.
 *
 *   4. findByCustomerEmail(String email) -> List<Account>
 *      Derived method (no @Query needed — Spring generates from the name).
 *
 *   5. findByBalanceGreaterThan(Money money) -> List<Account>
 *      Derived method using the converted Money attribute.
 *
 *   6. countByCustomer_Id(Long customerId) -> Long
 *      Derived method using nested traversal.
 *
 *   7. getAccountSummaries() -> List<AccountSummary>
 *      Use @Query with constructor projection or interface projection — return
 *      DTOs with accountNumber, customerName, balance.
 *
 *   8. findByIdForUpdate(Long id) -> Optional<Account>
 *      Pessimistic write lock — use @Lock(LockModeType.PESSIMISTIC_WRITE) + @Query.
 *
 * The repository also extends JpaSpecificationExecutor<Account> so 
 * TransactionSearchService can use Specifications.
 *
 * The AccountRepository is exercised indirectly by all service tests, and
 * directly by the DemoRunner under the "demo" profile.
 */
public interface AccountRepository extends JpaRepository<Account, Long>, 
                                            JpaSpecificationExecutor<Account> {

    // TODO: Define the 8 methods listed in the class Javadoc above.

}