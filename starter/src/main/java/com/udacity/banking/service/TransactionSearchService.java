package com.udacity.banking.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.udacity.banking.entity.Transaction;
import com.udacity.banking.repository.TransactionRepository;

/**
 * Service that composes Spring Data Specifications to build dynamic, 
 * filterable queries on the Transaction entity.
 *
 * EXERCISE: Implement searchTransactions by chaining specifications from
 * AccountSpecs (or wherever you keep your spec helpers). Any parameter
 * that is null should be ignored (no filter applied for that field).
 *
 * Example: searchTransactions(null, "DEPOSIT", null, null) should return all
 * transactions of type DEPOSIT regardless of account, date, or amount.
 */
@Service
public class TransactionSearchService {

    private final TransactionRepository transactionRepository;

    public TransactionSearchService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    /**
     * Search transactions with dynamic, composable filters. Null parameters
     * are ignored.
     *
     * @param accountId filter by account ID, or null for any account
     * @param type filter by transaction type ("DEPOSIT", "WITHDRAWAL", "TRANSFER"), or null
     * @param from filter for transactions on/after this date, or null
     * @param minAmount filter for transactions with amount >= this, or null
     * @return matching transactions
     *
     * TODO: Build a Specification<Transaction> by combining individual specs 
     *       conditionally (only AND in a spec when the corresponding param is not null).
     *       Then call transactionRepository.findAll(spec).
     */
    public List<Transaction> searchTransactions(Long accountId, String type, 
                                                LocalDateTime from, BigDecimal minAmount) {
        // TODO: implement this method
        throw new UnsupportedOperationException("Not yet implemented");
    }
}