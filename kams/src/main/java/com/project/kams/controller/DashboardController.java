package com.project.kams.controller;

import com.project.kams.model.DashboardResponse;
import com.project.kams.service.DashboardService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    private final DashboardService service;

    public DashboardController(DashboardService service) {
        this.service = service;
    }

    @GetMapping
    public DashboardResponse getDashboard() {
        return service.getDashboard();
    }
}