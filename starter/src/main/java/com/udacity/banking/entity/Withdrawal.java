package com.udacity.banking.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * This class is a withdrawal transaction representing money removed from an account.
 * 
 * A JOINED-inheritance subtype of Transaction. When persisted, Hibernate stores
 * the shared fields in the transaction table and links a row in the withdraw table
 * by shared id, and writes the discriminator value "WITHDRAWAL" to the type column
 * automatically based on @DiscriminatorValue.
 */
@Entity
@Table(name = "withdrawal")
@DiscriminatorValue("WITHDRAWAL")
public class Withdrawal extends Transaction {

    //Empty class no code needed here due to inheritance
    
}
