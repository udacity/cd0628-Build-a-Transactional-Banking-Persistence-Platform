package com.udacity.banking.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * MonthlyReport class - a Data Transfer Object (DTO) simply a placeholder for the
 * MonthlyReport data. Created and destroyed in Java memory.
 */
public class MonthlyReport {
    
    private LocalDateTime month;
    private Long transactionCount;
    private BigDecimal totalAmount;

    public MonthlyReport(LocalDateTime month, Long transactionCount, BigDecimal totalAmount)
    {
        this.month = month;
        this.transactionCount = transactionCount;
        this.totalAmount = totalAmount;

    }

    public LocalDateTime getMonth()
    { 
        return month; 

    }
    public Long getTransactionCount() 
    { 
        return transactionCount; 

    }
    public BigDecimal getTotalAmount() 
    { 
        return totalAmount; 
    }
}
