package com.allianz.example.model.requestDTO;

import com.allianz.example.database.entity.OrderEntity;
import com.allianz.example.util.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class BillRequestDTO extends BaseDTO {
    private String billNo;
    private LocalDateTime billDate;
    private BigDecimal taxRate;
    private BigDecimal taxAmount;
    private BigDecimal totalSellNetPrice;
    private BigDecimal totalSellPrice;
    private OrderEntity order;
}
