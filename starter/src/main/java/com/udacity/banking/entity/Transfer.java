package com.udacity.banking.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * This class is a transfer transaction representing money moved from one account to another account.
 * 
 * A JOINED-inheritance subtype of Transaction. When persisted, Hibernate stores
 * the shared fields in the transaction table and links a row in the transfer table
 * by shared id, and writes the discriminator value "TRANSFER" to the type column
 * automatically based on @DiscriminatorValue.
 */
@Entity
@Table(name = "transfer")
@DiscriminatorValue("TRANSFER")
public class Transfer extends Transaction {

    @ManyToOne
    @JoinColumn(name = "target_account_id", nullable = false)
    private Account targetAccount;

    public Account getTargetAccount() {
        return targetAccount;
    }

    public void setTargetAccount(Account targetAccount) {
        this.targetAccount = targetAccount;
    }
    
}
