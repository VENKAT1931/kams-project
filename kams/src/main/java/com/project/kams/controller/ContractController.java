package com.project.kams.controller;

import com.project.kams.model.Contract;
import com.project.kams.service.ContractService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contracts")
public class ContractController {

    private final ContractService service;

    public ContractController(ContractService service) {
        this.service = service;
    }

    @PostMapping
    public Contract create(@RequestBody Contract contract) {
        return service.save(contract);
    }

    @GetMapping
    public List<Contract> getAll() {
        return service.getAll();
    }
}