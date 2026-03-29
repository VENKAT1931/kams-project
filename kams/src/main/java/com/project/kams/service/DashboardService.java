package com.project.kams.service;

import com.project.kams.model.Contract;
import com.project.kams.model.DashboardResponse;
import com.project.kams.repository.ContractRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {

    private final ContractRepository contractRepo;

    public DashboardService(ContractRepository contractRepo) {
        this.contractRepo = contractRepo;
    }

    public DashboardResponse getDashboard() {

        List<Contract> contracts = contractRepo.findAll();

        double totalRevenue = 0;
        long active = 0;
        long expired = 0;

        for (Contract c : contracts) {
            totalRevenue += c.getContractValue();

            if ("Active".equalsIgnoreCase(c.getStatus())) {
                active++;
            } else if ("Expired".equalsIgnoreCase(c.getStatus())) {
                expired++;
            }
        }

        return new DashboardResponse(totalRevenue, active, expired);
    }
}