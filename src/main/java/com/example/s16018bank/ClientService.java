package com.example.s16018bank;

public class ClientService {
    private final ClientStorage clientStorage;

    public ClientService(ClientStorage clientStorage) {
        this.clientStorage = clientStorage;
    }

    public TransferInfo transferMoney(Client client, double amount) {
        client.setBalance(client.getBalance() - amount);
        return new TransferInfo(client.getBalance(), Status.ACCEPTED);
    }

    public TransferInfo depositMoney (Client client, double amount) {
        client.setBalance(client.getBalance() + amount);
        return new TransferInfo(client.getBalance(), Status.ACCEPTED);
    }
}
