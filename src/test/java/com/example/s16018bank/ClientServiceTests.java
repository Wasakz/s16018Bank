package com.example.s16018bank;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ClientServiceTests {

    @Test
    void shouldTransferMoney() throws Exception {
        // given
        ClientStorage clientStorage = new ClientStorage();
        ClientService clientService = new ClientService(clientStorage);
        Client client = clientStorage.registerClient(500);

        // when
        TransferInfo transferInfo = clientService.transferMoney(client.getId(), 499);

        //then
        assertEquals(transferInfo.getStatus(), Status.ACCEPTED);
    }

    @Test
    void shouldNotTransferAboveBalance() throws Exception {
        // given
        ClientStorage clientStorage = new ClientStorage();
        ClientService clientService = new ClientService(clientStorage);
        Client client = clientStorage.registerClient(10);

        // when
        TransferInfo transferInfo = clientService.transferMoney(client.getId(), 499);

        //then
        assertEquals(transferInfo.getStatus(), Status.DECLINED);
    }

    @Test
    void shouldCalculateMoneyAfterDeposit() throws Exception {
        // given
        ClientStorage clientStorage = new ClientStorage();
        ClientService clientService = new ClientService(clientStorage);
        Client client = clientStorage.registerClient(50);

        // when
        TransferInfo transferInfo = clientService.depositMoney(client.getId(), 50);

        //then
        assertEquals(transferInfo.getBalance(), 50 + 50);
    }

    @Test
    void shouldThrowErrorWhenClientNotFound() throws Exception {
        // given
        ClientStorage clientStorage = new ClientStorage();
        ClientService clientService = new ClientService(clientStorage);
        Client client = clientStorage.registerClient(50);

        // when
        Exception clientException = assertThrows(Exception.class, () -> clientService.transferMoney("123", 125));

        //then
        assertEquals(clientException.getMessage(), "no client");
    }
}
