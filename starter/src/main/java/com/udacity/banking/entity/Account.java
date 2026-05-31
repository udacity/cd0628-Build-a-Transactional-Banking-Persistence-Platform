package com.udacity.banking.entity;

import jakarta.persistence.*;

/**
 * The Account entity class that holds a unique id customer, and account related details.
 * This Account belongs to a customer and holds a balance. The Version annotation is 
 * included to allow for OptimisticLocking when checked at write time rather than pessimestic 
 * locking
 * 
 */

@Entity
@Table(name="account")
public class Account {

    @Version
    private Long version;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customer;

    @Column(name="account_number")
    private String accountNumber;

    @Column(name="balance")
    private Money balance;

    @Column(name="account_type")
    private String accountType;

    public Long getVersion()
    {
        return version;
    }

    public void setVersion(Long version) 
    {
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    
}
