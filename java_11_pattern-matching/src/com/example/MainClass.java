package com.example;

import com.example.model.Account;
import com.example.model.Invoice;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class MainClass {
    public static void main(String[] args) {
        int randomInt = ThreadLocalRandom.current().nextInt();
        Object model;
        if (randomInt % 2 ==0) {
            model = new Account("John");
        } else {
            model = new Invoice(LocalDate.now());
        }

        switch (model){
            case Account account -> System.out.println(account.getName());
            case Invoice invoice -> System.out.println(invoice.getIssueDate());
            default -> throw new IllegalStateException("Unexpected value: " + model);
        }
    }
}
