package com.example.pleasework.service;

import com.example.pleasework.model.Transaction;

import java.util.List;

public interface TransactionService {

    List<Transaction> getAllTransaction();

    void createTransaction(Transaction transaction);

    Transaction getTransactionById(Long id);

    void deleteTransactionById(Long id);


}
