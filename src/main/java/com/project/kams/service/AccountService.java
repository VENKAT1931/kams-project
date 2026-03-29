package com.project.kams.service;

import com.project.kams.model.Account;
import com.project.kams.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository repo;

    public AccountService(AccountRepository repo) {
        this.repo = repo;
    }

    public Account save(Account acc) {
        return repo.save(acc);
    }

    public List<Account> getAll() {
        return repo.findAll();
    }
}