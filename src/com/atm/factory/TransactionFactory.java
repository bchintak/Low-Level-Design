package com.atm.factory;

import com.atm.enums.TransactionStatus;
import com.atm.enums.TransactionType;
import com.atm.model.Transaction;

import java.util.UUID;

public class TransactionFactory {

    public static Transaction create(
            TransactionType type,
            double amount,
            TransactionStatus status) {

        return new Transaction(
                UUID.randomUUID()
                        .toString(),
                type,
                amount,
                status
        );
    }
}
