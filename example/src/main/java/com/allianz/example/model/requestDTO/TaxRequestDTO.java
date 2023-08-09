package com.allianz.example.model.requestDTO;

import com.allianz.example.util.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TaxRequestDTO extends BaseDTO {
    private String name;
    private String code;
    private BigDecimal rate;
}
