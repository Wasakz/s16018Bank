package com.example.s16018bank;

import java.util.UUID;

public class Client {
    private String id;
    private double balance;

    public Client(double balance) {
        this.id = UUID.randomUUID().toString();
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }
}
