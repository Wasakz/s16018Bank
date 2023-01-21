package com.example.s16018bank;

import java.util.ArrayList;
import java.util.List;

public class ClientStorage {
    private List<Client> clientList = new ArrayList<>();

    public ClientStorage(List<Client> clientList) {
        // Add some initial data to Client storage
        registerClient(50);
        registerClient(150);
        registerClient(521523);
    }

    public void registerClient(double balance) {
        Client client = new Client(balance);
    }

    public void transferMoney()
}
