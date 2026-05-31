package com.udacity.banking.entity;

import java.util.List;

import org.hibernate.annotations.BatchSize;

import jakarta.persistence.*;

/**
 * Customer entity with unique id, name and customer fields for address.
 * A Customer can have one or more accounts.
 * 
 */
@Entity
@Table(name = "customer")
public class Customer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Embedded
    private Address address;


    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    @BatchSize(size = 5)
    private List<Account> accounts;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }    

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public List<Account> getAccounts() {
        return accounts;
    }
    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

}
