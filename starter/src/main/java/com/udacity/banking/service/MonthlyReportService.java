package com.udacity.banking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.udacity.banking.dto.MonthlyReport;
import com.udacity.banking.repository.TransactionRepository;

/**
 * Service for generating a monthly transaction report.
 *
 * EXERCISE: Implement getMonthlyReport by delegating to a TransactionRepository
 * method that uses a native SQL query (PostgreSQL date_trunc, grouping, count, sum)
 * to compute per-month totals. The repository method should map to the MonthlyReport
 * DTO using SqlResultSetMapping or constructor projection.
 */
@Service
public class MonthlyReportService {

    private final TransactionRepository transactionRepository;

    public MonthlyReportService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    /**
     * Return the per-month transaction report (month, count, total amount).
     *
     * @return list of MonthlyReport rows, one per month with activity
     *
     * TODO: Call the native query on transactionRepository that returns 
     *       MonthlyReport rows.
     */
    public List<MonthlyReport> getMonthlyReport() {
        // TODO: implement this method
        throw new UnsupportedOperationException("Not yet implemented");
    }
}