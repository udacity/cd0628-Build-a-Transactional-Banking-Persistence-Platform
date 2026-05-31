package com.udacity.banking.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * This class is a deposit transaction representing money added to an account.
 * 
 * A JOINED-inheritance subtype of Transaction. When persisted, Hibernate stores
 * the shared fields in the transaction table and links a row in the deposit table
 * by shared id, and writes the discriminator value "DEPOSIT" to the type column
 * automatically based on @DiscriminatorValue.
 */
@Entity
@Table(name = "deposit")
@DiscriminatorValue("DEPOSIT")
public class Deposit extends Transaction {

    //Empty class no code needed here due to inheritance
    
}
