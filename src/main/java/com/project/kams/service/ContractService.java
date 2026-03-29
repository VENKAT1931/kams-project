package com.project.kams.service;

import com.project.kams.model.Contract;
import com.project.kams.model.Account;
import com.project.kams.repository.ContractRepository;
import com.project.kams.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ContractService {

    private final ContractRepository contractRepo;
    private final AccountRepository accountRepo;

    public ContractService(ContractRepository contractRepo, AccountRepository accountRepo) {
        this.contractRepo = contractRepo;
        this.accountRepo = accountRepo;
    }

    public Contract save(Contract contract) {

        if (contract.getAccount() == null) {
            throw new RuntimeException("Account is null");
        }

        Long accountId = contract.getAccount().getId();

        Account account = accountRepo.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found with id: " + accountId));

        contract.setAccount(account);

        // 🔥 Status logic
        if (contract.getEndDate() != null && contract.getEndDate().isBefore(LocalDate.now())) {
            contract.setStatus("Expired");
        } else {
            contract.setStatus("Active");
        }

        return contractRepo.save(contract);
    }

    // ✅ ADD THIS METHOD (THIS FIXES YOUR ERROR)
    public List<Contract> getAll() {
        return contractRepo.findAll();
    }
}