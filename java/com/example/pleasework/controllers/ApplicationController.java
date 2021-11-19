package com.example.pleasework.controllers;

import com.example.pleasework.model.*;
import com.example.pleasework.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/application")
public class ApplicationController {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TypesRepositroy typesRepositroy;


    @GetMapping("/transactions")
    public String getMainAppPage(Model model) {
        model.addAttribute("transaction", new Transaction());

        List<Transaction> transactionList = transactionRepository.findAll();
        model.addAttribute("transactionList", transactionList);

        List<Category> categoryList = categoryRepository.findAll();
        model.addAttribute("categoryList", categoryList);

        List<Account> accountList = accountRepository.findAll();
        model.addAttribute("accountList", accountList);

        List<TypeOfTransaction> typesList = typesRepositroy.findAll();
        model.addAttribute("typesList", typesList);
        return "application";
    }
    /* ---------------------- TRANSACTION MANIPULATIONS ----------------------*/

    @PostMapping("/createTransaction")
    public String createTransaction(@ModelAttribute("transaction") Transaction transaction) {
        transactionRepository.save(transaction);
        return "redirect:/application/transactions";
    }

    @GetMapping("/TransactionUpdateForm/{id}")
    public String showUpdateForm(@PathVariable(value = "id") Long id, Model model) {
        Transaction transaction = transactionRepository.getById(id);
        model.addAttribute("transaction", transaction);

        List<Transaction> transactionList = transactionRepository.findAll();
        model.addAttribute("transactionList", transactionList);

        List<Category> categoryList = categoryRepository.findAll();
        model.addAttribute("categoryList", categoryList);

        List<Account> accountList = accountRepository.findAll();
        model.addAttribute("accountList", accountList);

        List<TypeOfTransaction> typesList = typesRepositroy.findAll();
        model.addAttribute("typesList", typesList);
        return "updateTransaction";
    }

    @GetMapping("/deleteTransaction/{id}")
    public String deleteTransaction(@PathVariable(value = "id") Long id) {
        this.transactionRepository.deleteById(id);
        return "redirect:/application/transactions";
    }

    /* ---------------------- CATEGORY MANIPULATIONS ----------------------*/

    @GetMapping("/categories")
    public String getAppCategoryPage(Model model) {
        model.addAttribute("category", new Category());
        List<Category> categoryList = categoryRepository.findAll();
        model.addAttribute("categoryList", categoryList);
        return "categories";
    }

    @PostMapping("/createCategory")
    public String createCategory(@ModelAttribute("category") Category category) {
        categoryRepository.save(category);
        return "redirect:/application/categories";
    }

    @GetMapping("/CategoryUpdateForm/{id}")
    public String CategoryUpdateForm(@PathVariable(value = "id") Integer id, Model model) {
        Category category = categoryRepository.getById(id);
        model.addAttribute("category", category);
        return "updateCategory";
    }

    @GetMapping("/deleteCategory/{id}")
    public String deleteCategory(@PathVariable(value = "id") Integer id) {
        this.categoryRepository.deleteById(id);
        return "redirect:/application/categories";
    }

    /* ---------------------- ACCOUNT MANIPULATIONS ----------------------*/
    @GetMapping("/accounts")
    public String getAppAccountsPage(Model model) {
        model.addAttribute("account", new Account());
        List<Account> accountList = accountRepository.findAll();
        model.addAttribute("accountList", accountList);
        return "accounts";
    }

    @PostMapping("/createAccount")
    public String createAccount(@ModelAttribute("account") Account account) {
        accountRepository.save(account);
        return "redirect:/application/accounts";
    }

    @GetMapping("/AccountUpdateForm/{id}")
    public String AccountUpdateForm(@PathVariable(value = "id") Integer id, Model model) {
        Account account = accountRepository.getById(id);
        model.addAttribute("account", account);
        return "updateAccount";
    }

    @GetMapping("/deleteAccount/{id}")
    public String deleteAccount(@PathVariable(value = "id") Integer id) {
        this.accountRepository.deleteById(id);
        return "redirect:/application/accounts";
    }
}