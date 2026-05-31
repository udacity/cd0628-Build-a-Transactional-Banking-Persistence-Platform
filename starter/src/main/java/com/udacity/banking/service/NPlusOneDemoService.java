package com.udacity.banking.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.udacity.banking.repository.CustomerRepository;

/**
 * Demonstrates the N+1 query problem and three fixes.
 *
 * EXERCISE: Implement the three demo methods. Each loads customers and 
 * iterates their accounts, but uses a different repository method.
 *
 * IMPORTANT — Why is each method @Transactional?
 * Because Customer.accounts is LAZY-loaded. Iterating accounts outside a
 * transaction would fail with LazyInitializationException ("no session").
 * @Transactional keeps the Hibernate session open for the duration of the
 * method so lazy loads succeed.
 *
 * What you'll observe in the SQL (with the demo profile):
 *   - demoDefault: 2 queries (1 customer + 1 batched accounts via @BatchSize)
 *   - demoJoinFetch: 1 query (JPQL JOIN FETCH)
 *   - demoEntityGraph: 1 query (@EntityGraph hint)
 */
@Service
public class NPlusOneDemoService {

    private final CustomerRepository customerRepository;

    public NPlusOneDemoService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /**
     * Default findAll() + iterate accounts. With @BatchSize on Customer.accounts,
     * this should produce 2 queries instead of N+1.
     *
     * TODO: Add @Transactional, load all customers via customerRepository.findAll(),
     *       then iterate each customer and print their account count.
     */
    public void demoDefault() {
        // TODO: implement this method
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * JOIN FETCH demo — uses customerRepository.findAllWithJoinFetch() which 
     * runs a single JPQL query with LEFT JOIN FETCH.
     *
     * TODO: Add @Transactional, load via findAllWithJoinFetch, iterate and print.
     */
    public void demoJoinFetch() {
        // TODO: implement this method
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @EntityGraph demo — uses customerRepository.findAllWithEntityGraph() which
     * uses Spring's @EntityGraph hint instead of writing JPQL.
     *
     * TODO: Add @Transactional, load via findAllWithEntityGraph, iterate and print.
     */
    public void demoEntityGraph() {
        // TODO: implement this method
        throw new UnsupportedOperationException("Not yet implemented");
    }
}