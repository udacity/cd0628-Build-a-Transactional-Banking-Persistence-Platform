package com.udacity.banking.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.udacity.banking.entity.Account;
import com.udacity.banking.entity.Transfer;
import com.udacity.banking.repository.AccountRepository;

/**
 * Test to check the transfer service works correctly.
 * 
 */
@SpringBootTest
@Transactional
public class TransferServiceTest {
    
    @Autowired
    private TransferService transferService;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    void makeTransfer_decreasesSourceIncreasesTarget() 
    {
        Account sourceBefore = accountRepository.findById(1L).orElseThrow();
        Account targetBefore = accountRepository.findById(3L).orElseThrow();

        BigDecimal sourceBalanceBefore = sourceBefore.getBalance().getAmount();
        BigDecimal targetBalanceBefore = targetBefore.getBalance().getAmount();

        BigDecimal transferAmount = new BigDecimal("30");

        //now make a transfer
        Transfer transfer = transferService.makeTransfer(1L, 3L, transferAmount);

        //use assert statements to check the transfer was created
        assertNotNull(transfer);
        assertNotNull(transfer.getId());
       
        Account sourceAfter = accountRepository.findById(1L).orElseThrow();
        Account targetAfter = accountRepository.findById(3L).orElseThrow();

        BigDecimal expectedSourceBalance = sourceBalanceBefore.subtract(transferAmount);
        BigDecimal expectedTargetBalance = targetBalanceBefore.add(transferAmount);
        
        assertEquals(0, sourceAfter.getBalance().getAmount().compareTo(expectedSourceBalance),
            "Source balance should have decreased by " + transferAmount);

        assertEquals(0, targetAfter.getBalance().getAmount().compareTo(expectedTargetBalance),
            "Target balance should have increased by " + transferAmount);
    
    }

}
