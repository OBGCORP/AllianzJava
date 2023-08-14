package com.allianz.example.model;

import com.allianz.example.util.BaseDTO;
import jakarta.persistence.Column;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TaxDTO extends BaseDTO {
    private String name;
    private String code;
    private BigDecimal rate;
}
