package com.project.kams.controller;

import com.project.kams.model.Account;
import com.project.kams.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @PostMapping
    public Account create(@RequestBody Account acc) {
        return service.save(acc);
    }

    @GetMapping
    public List<Account> getAll() {
        return service.getAll();
    }
}