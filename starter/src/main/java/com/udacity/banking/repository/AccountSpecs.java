package com.udacity.banking.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.jpa.domain.Specification;

import com.udacity.banking.entity.Transaction;

/**
 * Reusable Specification builders for filtering Transaction entities.
 *
 * These specs are composed (and-ed together) by TransactionSearchService to
 * produce dynamic queries — only the predicates for non-null filter values
 * end up in the SQL.
 *
 * EXERCISE: Implement each builder to return a Specification<Transaction>
 * that adds the predicate to the query. Use the CriteriaBuilder passed into
 * the toPredicate lambda.
 *
 * Hints:
 *   - hasAccount: cb.equal(root.get("account").get("id"), accountId)
 *   - hasType: cb.equal(root.get("type"), type)  
 *     (this maps to the @DiscriminatorColumn — Hibernate adds the dtype = ? predicate)
 *   - createdAfter: cb.greaterThanOrEqualTo(root.get("createdAt"), from)
 *   - amountAtLeast: cb.greaterThanOrEqualTo(root.get("amount"), minAmount)
 */
public final class AccountSpecs {

    private AccountSpecs() {
        // utility class — prevent instantiation
    }

    /**
     * @return spec that matches transactions on the given account
     *
     * TODO: implement
     */
    public static Specification<Transaction> hasAccount(Long accountId) {
        // TODO: implement this method
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @return spec that matches transactions of the given type ("DEPOSIT", etc.)
     *
     * TODO: implement
     */
    public static Specification<Transaction> hasType(String type) {
        // TODO: implement this method
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @return spec that matches transactions created on or after the given timestamp
     *
     * TODO: implement
     */
    public static Specification<Transaction> createdAfter(LocalDateTime from) {
        // TODO: implement this method
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @return spec that matches transactions with amount >= minAmount
     *
     * TODO: implement
     */
    public static Specification<Transaction> amountAtLeast(BigDecimal minAmount) {
        // TODO: implement this method
        throw new UnsupportedOperationException("Not yet implemented");
    }
}