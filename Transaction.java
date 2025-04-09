package com.example.rewards;

import java.time.LocalDate;

/**
 * Represents a transaction by a customer.
 */
public class Transaction {
    private Long customerId;
    private LocalDate date;
    private double amount;

    public Transaction(Long customerId, LocalDate date, double amount) {
        this.customerId = customerId;
        this.date = date;
        this.amount = amount;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }
}
