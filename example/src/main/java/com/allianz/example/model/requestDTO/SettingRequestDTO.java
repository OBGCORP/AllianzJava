package com.allianz.example.model.requestDTO;

import com.allianz.example.util.BaseDTO;
import lombok.Data;

@Data
public class SettingRequestDTO extends BaseDTO {
    private String key;
    private String value;
}
