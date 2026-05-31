package com.udacity.banking.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.OptimisticLockingFailureException;

/**
 * Simple unit test to simulate a conflict and test the thrown exception.
 */
@SpringBootTest
public class OptimisticLockingDemoServiceTest {
    
    @Autowired
    private OptimisticLockingDemoService optimisticLockingDemoService;

    @Test
    void simulateConflict_throwsOptimisticLockingFailureException() {

        boolean exceptionThrown = false;

        try 
        {
            optimisticLockingDemoService.simulateConflict(2L);
        } 
        catch(OptimisticLockingFailureException optimisticLockingFailureException)
        {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown, "Excpected OptimisticLockingFailureException");
    }

}
