package com.allianz.example.model;

import com.allianz.example.util.BaseDTO;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class SettingsDTO extends BaseDTO {
    private String key;
    private String value;
}
