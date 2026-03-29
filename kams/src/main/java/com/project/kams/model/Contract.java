package com.project.kams.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private double contractValue;

    private LocalDate startDate;
    private LocalDate endDate;

    private String status;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public Long getId() { return id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }


    public double getContractValue() { return contractValue; }
    public void setContractValue(double contractValue) { this.contractValue = contractValue; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Account getAccount() { return account; }
    public void setAccount(Account account) { this.account = account; }
}