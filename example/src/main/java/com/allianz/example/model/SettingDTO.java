package com.allianz.example.model;

import com.allianz.example.util.BaseDTO;
import lombok.Data;

@Data
public class SettingDTO extends BaseDTO {
    private String key;
    private String value;
}
