package com.example.s16018bank;

import java.util.ArrayList;
import java.util.List;

public class ClientStorage {
    private List<Client> clientList = new ArrayList<>();

    public ClientStorage(List<Client> clientList) {
        Client client1 = new Client("123", 50);
        Client client2 = new Client("321", 150);
    }
}
