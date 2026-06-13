package com.atm.service;

import com.atm.model.Transaction;

public class ReceiptService {

    public void printReceipt(
            Transaction transaction) {

        System.out.println(
                "=================="
        );

        System.out.println(
                "Txn Id : "
                        + transaction.getTransactionId()
        );

        System.out.println(
                "Status : "
                        + transaction.getStatus()
        );

        System.out.println(
                "Amount : "
                        + transaction.getAmount()
        );

        System.out.println(
                "=================="
        );
    }
}
