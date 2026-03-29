package com.project.kams.model;

public class DashboardResponse {

    private double totalRevenue;
    private long activeContracts;
    private long expiredContracts;

    public DashboardResponse(double totalRevenue, long activeContracts, long expiredContracts) {
        this.totalRevenue = totalRevenue;
        this.activeContracts = activeContracts;
        this.expiredContracts = expiredContracts;
    }

    public double getTotalRevenue() { return totalRevenue; }
    public long getActiveContracts() { return activeContracts; }
    public long getExpiredContracts() { return expiredContracts; }
}