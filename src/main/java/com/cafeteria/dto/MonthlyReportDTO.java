package com.cafeteria.dto;

import java.math.BigDecimal;
import java.util.Map;

public class MonthlyReportDTO {
    private int year;
    private int month;
    private BigDecimal revenue;
    private Map<String, Integer> counts;

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
    public int getMonth() { return month; }
    public void setMonth(int month) { this.month = month; }
    public BigDecimal getRevenue() { return revenue; }
    public void setRevenue(BigDecimal revenue) { this.revenue = revenue; }
    public Map<String, Integer> getCounts() { return counts; }
    public void setCounts(Map<String, Integer> counts) { this.counts = counts; }
}
