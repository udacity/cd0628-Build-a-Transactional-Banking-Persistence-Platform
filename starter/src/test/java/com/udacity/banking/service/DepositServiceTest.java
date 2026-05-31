package com.udacity.banking.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.udacity.banking.entity.Account;
import com.udacity.banking.entity.Deposit;
import com.udacity.banking.repository.AccountRepository;

/**
 * makeDeposit - places a deposit and the assert functionality checks to make
 * sure that deposit was made
 */
@SpringBootTest
@Transactional
public class DepositServiceTest {
    
    @Autowired
    private DepositService depositService;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    void makeDeposit_increasesAccountBalance() 
    {
        Account before = accountRepository.findById(1L).orElseThrow();

        BigDecimal balanceBefore = before.getBalance().getAmount();

        BigDecimal depositAmount = new BigDecimal("100");

        //now make a deposit
        Deposit deposit = depositService.makeDeposit(1L, depositAmount);

        //use assert statements to check the deposit was created
        assertNotNull(deposit);
        assertNotNull(deposit.getId());
        assertEquals(0, deposit.getAmount().getAmount().compareTo(depositAmount));

        //check the account balance increased by the deposit amount
        Account after = accountRepository.findById(1L).orElseThrow();

        BigDecimal expectedBalance = balanceBefore.add(depositAmount);
        assertEquals(0, after.getBalance().getAmount().compareTo(expectedBalance),
            "Balance should have increased by : " + depositAmount);
    }


}
