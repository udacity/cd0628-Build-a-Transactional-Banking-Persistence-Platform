package com.udacity.banking.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;

/**
 * Transaction entity representing a money movement such as deposit, withdrawal or transfer
 * that belongs to an account along with the amount and the time the transaction was created.
 */
@Entity
@Table(name="transaction")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")
@SqlResultSetMapping(
    name = "MonthlyReportMapping",
    classes = @ConstructorResult(
        targetClass = com.udacity.banking.dto.MonthlyReport.class,
        columns = {
            @ColumnResult(name = "month", type = java.time.LocalDateTime.class),
            @ColumnResult(name = "transaction_count", type = Long.class),
            @ColumnResult(name = "total_amount", type = java.math.BigDecimal.class)
        }
    )
)
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="account_id", nullable=false)
    private Account account;

    private Money amount;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column()
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Money getAmount() {
        return amount;
    }

    public void setAmount(Money amount) {
        this.amount = amount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
