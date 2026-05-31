package com.udacity.banking.exception;

/**
 * An unchecked exception thrown when there is not enough of a balanc in the account.
 * Springs @Transactional will roll back this transaction automatically.
 * 
 */
public class InsufficientFundsException extends RuntimeException {
    
    public InsufficientFundsException(String message)
    {
        super(message);
    }
}
