package com.udacity.banking.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.udacity.banking.exception.InsufficientFundsException;
import com.udacity.banking.repository.AuditLogRepository;

/**
 * This test class puts in a false call to the repository for a transfer and
 * checks to see if it is rolledback.
 */
@SpringBootTest
public class AuditLogServiceTest {
    
    @Autowired
    private TransferService transferService;

    @Autowired
    private AuditLogRepository auditLogRepository;

    @Test
    void failedTransfer_auditRowStillCommited() 
    {
        //grab the count for the audit row before 
        long countBefore = auditLogRepository.count();

        //make an over the account balance transfer
        boolean exceptionThrown = false;

        try 
        {
            transferService.makeTransfer(1L, 3L, new BigDecimal("99999"));

        } 
        catch(InsufficientFundsException insufficientFundsException)
        {
            exceptionThrown = true;
        }

        assertTrue(exceptionThrown, "Insufficent funds exception");

        //get the audit count again - it should be +1
        long countAfter = auditLogRepository.count();
        assertEquals(countBefore+1, countAfter, 
            "Audit row should still be OK from the rollback as REQUIRES_NEW is used");

        //delete the row for testing that we created
        auditLogRepository.deleteById(
            auditLogRepository.findAll().get(auditLogRepository.findAll().size() -1).getId());

    }
}
