package com.example.s16018bank;

public class TransferInfo {
    double balance;
    Status status;

    public TransferInfo(double balance, Status status) {
        this.balance = balance;
        this.status = status;
    }

    public double getBalance() {
        return balance;
    }

    public Status getStatus() {
        return status;
    }
}
