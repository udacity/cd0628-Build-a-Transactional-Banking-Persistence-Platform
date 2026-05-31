package com.udacity.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udacity.banking.entity.Customer;

/**
 * Repository for Customer entities. Demonstrates the N+1 problem and three fixes.
 *
 * EXERCISE: Add two custom finder methods that load Customer entities WITH
 * their accounts collection eagerly:
 *
 *   1. findAllWithJoinFetch() -> List<Customer>
 *      Use @Query JPQL with LEFT JOIN FETCH on accounts. Add DISTINCT to 
 *      collapse duplicate Customer rows from the join.
 *
 *   2. findAllWithEntityGraph() -> List<Customer>
 *      Use @EntityGraph(attributePaths = "accounts") + @Query("SELECT c FROM Customer c")
 *      Spring/Hibernate translates the hint into a join.
 *
 * The default findAll() (inherited from JpaRepository) demonstrates the
 * baseline behavior — combined with @BatchSize(size = 5) on Customer.accounts,
 * the default path produces 2 queries (1 customer + 1 batched accounts) 
 * instead of N+1.
 *
 * Compare the SQL produced by each approach in the DemoRunner output.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // TODO: Define findAllWithJoinFetch() and findAllWithEntityGraph().

}