package com.example.pleasework.service;

import com.example.pleasework.model.Account;

import java.util.List;

public interface AccountService {

    List<Account> getAllAccounts();

    void createAccount(Account account);

    Account getAccountById(Integer id);

    void deleteAccountById(Integer id);


}
