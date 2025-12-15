package com.cafeteria.service;

import com.cafeteria.dto.BlanketLineDTO;
import com.cafeteria.dto.MonthlyReportDTO;

import java.time.LocalDate;
import java.util.List;

public interface ReportService {
    List<BlanketLineDTO> generateBlanketOrder(LocalDate date);
    MonthlyReportDTO generateMonthlyReport(int year, int month);
}
