package com.example.pleasework.service;

import com.example.pleasework.model.Transaction;
import com.example.pleasework.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<Transaction> getAllTransaction() {
        return transactionRepository.findAll();
    }

    @Override
    public void createTransaction(Transaction transaction) {
        this.transactionRepository.save(transaction);
    }

    @Override
    public Transaction getTransactionById(Long id) {
        Optional<Transaction> optionalAccount = transactionRepository.findById(id);
        Transaction transaction = null;
        if (optionalAccount.isPresent()) {
            transaction = optionalAccount.get();
        } else {
            throw new RuntimeException("Employee with " + id + " does not found");
        }
        return transaction;
    }

    @Override
    public void deleteTransactionById(Long id) {
        this.transactionRepository.deleteById(id);
    }
}
