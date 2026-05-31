package com.udacity.banking.entity;

import java.math.BigDecimal;

/**
 * Class Money that holds the amount as a BigDecimal.
 */

public class Money {

    private final BigDecimal amount;

    public Money(BigDecimal amount)
    {
        this.amount = amount;

    }

    public BigDecimal getAmount() {
        return amount;
    }
}


