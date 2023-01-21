package com.example.s16018bank;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
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

    public List<Client> getAllClients() {
        return clientList;
    }

    public Client findClientById(String id) throws Exception {
        Optional<Client> findClient = getAllClients().stream().filter(el -> el.getId().equals(id)).findFirst();
        if(findClient.isEmpty()) throw new Exception("no client");
        return findClient.get();
    }
}
