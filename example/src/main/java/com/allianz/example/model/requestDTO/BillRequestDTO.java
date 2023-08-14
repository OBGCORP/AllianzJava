package com.allianz.example.model.requestDTO;

import com.allianz.example.util.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class BillRequestDTO extends BaseDTO {

    private String billNo;
    private BigDecimal totalSellNetPrice;
    private BigDecimal totalSellPrice;
}
