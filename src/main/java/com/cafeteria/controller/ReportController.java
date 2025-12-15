package com.cafeteria.controller;

import com.cafeteria.dto.BlanketLineDTO;
import com.cafeteria.dto.MonthlyReportDTO;
import com.cafeteria.service.ReportService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportController {
    private final ReportService reportService;

    public ReportController(ReportService reportService) { this.reportService = reportService; }

    @GetMapping("/blanket")
    public ResponseEntity<List<BlanketLineDTO>> blanket(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok(reportService.generateBlanketOrder(date));
    }

    @GetMapping("/monthly")
    public ResponseEntity<MonthlyReportDTO> monthly(@RequestParam int year, @RequestParam int month) {
        return ResponseEntity.ok(reportService.generateMonthlyReport(year, month));
    }
}
