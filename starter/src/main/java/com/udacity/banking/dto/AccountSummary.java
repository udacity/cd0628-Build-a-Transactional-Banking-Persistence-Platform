package com.udacity.banking.dto;

import com.udacity.banking.entity.Money;
/**
 * An interface to enable projection showing a read only summary view of an Account.
 * The Spring Data JPA framework will implement this interface at runtime and populate
 * the fields from the query results by name.
 */
public interface AccountSummary {
    String getAccountNumber();
    Money getBalance();
    String getCustomerName();
}
