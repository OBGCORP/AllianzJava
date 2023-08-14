package com.allianz.example.model.requestDTO;

import com.allianz.example.model.ProductDTO;
import com.allianz.example.util.BaseDTO;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class CategoryRequestDTO extends BaseDTO {
    private String name;
    private Set<ProductRequestDTO> productList = new HashSet<>();


}
