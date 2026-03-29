package com.project.kams.service;

import com.project.kams.model.Contact;
import com.project.kams.model.Account;
import com.project.kams.repository.ContactRepository;
import com.project.kams.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    private final ContactRepository contactRepo;
    private final AccountRepository accountRepo;

    public ContactService(ContactRepository contactRepo, AccountRepository accountRepo) {
        this.contactRepo = contactRepo;
        this.accountRepo = accountRepo;
    }

    public Contact save(Contact contact) {

        Long accountId = contact.getAccount().getId();

        Account account = accountRepo.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        contact.setAccount(account);

        return contactRepo.save(contact);
    }

    public List<Contact> getAll() {
        return contactRepo.findAll();
    }
}