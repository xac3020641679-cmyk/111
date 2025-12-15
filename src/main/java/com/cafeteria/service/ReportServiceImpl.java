package com.cafeteria.service;

import com.cafeteria.dto.BlanketLineDTO;
import com.cafeteria.dto.MonthlyReportDTO;
import com.cafeteria.model.OrderItem;
import com.cafeteria.repository.OrderItemRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements ReportService {
    private final OrderItemRepository orderItemRepository;

    public ReportServiceImpl(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public List<BlanketLineDTO> generateBlanketOrder(LocalDate date) {
        List<OrderItem> items = orderItemRepository.findByOrderOrderDate(date);
        Map<Long, BlanketLineDTO> map = new HashMap<>();
        for (OrderItem it : items) {
            BlanketLineDTO line = map.get(it.getRecipeId());
            if (line == null) {
                line = new BlanketLineDTO(it.getRecipeId(), it.getRecipeName(), 0);
                map.put(it.getRecipeId(), line);
            }
            line.setQuantity(line.getQuantity() + (it.getQuantity() == null ? 0 : it.getQuantity()));
        }
        return map.values().stream().collect(Collectors.toList());
    }

    @Override
    public MonthlyReportDTO generateMonthlyReport(int year, int month) {
        YearMonth ym = YearMonth.of(year, month);
        LocalDate start = ym.atDay(1);
        LocalDate end = ym.atEndOfMonth();
        List<OrderItem> items = orderItemRepository.findByOrderOrderDateBetween(start, end);

        Map<String, Integer> counts = new HashMap<>();
        BigDecimal revenue = BigDecimal.ZERO;
        for (OrderItem it : items) {
            String name = it.getRecipeName();
            counts.put(name, counts.getOrDefault(name, 0) + (it.getQuantity() == null ? 0 : it.getQuantity()));
            revenue = revenue.add(it.getSubtotal() == null ? BigDecimal.ZERO : it.getSubtotal());
        }

        MonthlyReportDTO dto = new MonthlyReportDTO();
        dto.setMonth(month);
        dto.setYear(year);
        dto.setRevenue(revenue);
        dto.setCounts(counts);
        return dto;
    }
}
