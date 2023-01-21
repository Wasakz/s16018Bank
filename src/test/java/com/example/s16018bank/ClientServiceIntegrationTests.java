package com.example.s16018bank;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ClientServiceIntegrationTests {
    @Autowired
    ClientStorage clientStorage = new ClientStorage();
    @Autowired
    ClientService clientService = new ClientService(clientStorage);
    @Test
    void shouldTransferMoney() throws Exception {
        // given
        Client client = clientStorage.registerClient(500);

        // when
        TransferInfo transferInfo = clientService.transferMoney(client.getId(), 499);

        //then
        assertEquals(transferInfo.getStatus(), Status.ACCEPTED);
    }

    @Test
    void shouldNotTransferAboveBalance() throws Exception {
        // given
        Client client = clientStorage.registerClient(10);

        // when
        TransferInfo transferInfo = clientService.transferMoney(client.getId(), 499);

        //then
        assertEquals(transferInfo.getStatus(), Status.DECLINED);
    }

    @Test
    void shouldCalculateMoneyAfterDeposit() throws Exception {
        // given
        Client client = clientStorage.registerClient(50);

        // when
        TransferInfo transferInfo = clientService.depositMoney(client.getId(), 50);

        //then
        assertEquals(transferInfo.getBalance(), 50 + 50);
    }

    @Test
    void shouldThrowErrorWhenClientNotFound() throws Exception {
        // given
        Client client = clientStorage.registerClient(50);

        // when
        Exception clientException = assertThrows(Exception.class, () -> clientService.transferMoney("123", 125));

        //then
        assertEquals(clientException.getMessage(), "no client");
    }
}
