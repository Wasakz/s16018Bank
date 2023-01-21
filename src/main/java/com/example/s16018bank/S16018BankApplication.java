package com.example.s16018bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class S16018BankApplication {
    private ClientService clientService;

    public S16018BankApplication(ClientService clientService) {
        this.clientService = clientService;
    }

    public static void main(String[] args) {
        SpringApplication.run(S16018BankApplication.class, args);
    }

}
