package com.example.s16018bank;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ClientService {
    private final ClientStorage clientStorage;

    public ClientService(ClientStorage clientStorage) {
        this.clientStorage = clientStorage;
    }

    public TransferInfo transferMoney(Client client, double amount) {
        if(client.getBalance() - amount < 0) return new TransferInfo(client.getBalance(), Status.DECLINED);
        client.setBalance(client.getBalance() - amount);
        return new TransferInfo(client.getBalance(), Status.ACCEPTED);
    }

    public TransferInfo depositMoney (Client client, double amount) {
        client.setBalance(client.getBalance() + amount);
        return new TransferInfo(client.getBalance(), Status.ACCEPTED);
    }

    public Client getClientInfo(String id) throws Exception {
        return this.clientStorage.findClientById(id);
    }
}
