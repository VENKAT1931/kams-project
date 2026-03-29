package com.project.kams.controller;

import com.project.kams.model.Contact;
import com.project.kams.service.ContactService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private final ContactService service;

    public ContactController(ContactService service) {
        this.service = service;
    }

    @PostMapping
    public Contact create(@RequestBody Contact contact) {
        return service.save(contact);
    }

    @GetMapping
    public List<Contact> getAll() {
        return service.getAll();
    }
}