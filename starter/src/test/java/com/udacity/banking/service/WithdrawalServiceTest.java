package com.udacity.banking.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.udacity.banking.entity.Account;
import com.udacity.banking.entity.Withdrawal;
import com.udacity.banking.exception.InsufficientFundsException;
import com.udacity.banking.repository.AccountRepository;

/**
 * Withdrawal test class to check that the withdrawal service is correctly 
 * withdrawing money by using asserts. Also a check is done on the rollback 
 * of a transaction if there is not enough funds in the account.
 */
@SpringBootTest
@Transactional
public class WithdrawalServiceTest {
    
    @Autowired
    private WithdrawalService withdrawalService;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    void makeWithdrawal_decreasesAccountBalance() 
    {
        Account before = accountRepository.findById(1L).orElseThrow();

        BigDecimal balanceBefore = before.getBalance().getAmount();

        BigDecimal withdrawAmount = new BigDecimal("50");

        //now make a withdrawal
        Withdrawal withdrawal = withdrawalService.makeWithdrawal(1L, withdrawAmount);

        //use assert statements to check the withdrawal was created
        assertNotNull(withdrawal);
        assertNotNull(withdrawal.getId());

         //check the account balance increased by the deposit amount
        Account after = accountRepository.findById(1L).orElseThrow();

        BigDecimal expectedBalance = balanceBefore.subtract(withdrawAmount);
        assertEquals(0, after.getBalance().getAmount().compareTo(expectedBalance),
            "Balance should have decreased by : " + withdrawAmount);

    }

    @Test
    void makeWithdrawal_checkForOverBalance_throwsAndRollsBack() 
    {
        Account before = accountRepository.findById(1L).orElseThrow();

        BigDecimal balanceBefore = before.getBalance().getAmount();

        BigDecimal overdraftAmount = new BigDecimal("99999");

        //the assert throws
        boolean exceptionThrown = false;
        try
        {
            withdrawalService.makeWithdrawal(1L, overdraftAmount);

        } 
        catch(InsufficientFundsException insufficientFundsException)
        {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown, "Expected Insufficient Funds Exception");

        //check the account balance increased by the deposit amount
        Account after = accountRepository.findById(1L).orElseThrow();

        assertEquals(0, after.getBalance().getAmount().compareTo(balanceBefore),
            "Balance should be unchanged after the rollback");
    }

}
