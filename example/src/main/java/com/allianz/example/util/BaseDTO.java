package com.allianz.example.util;

import jakarta.persistence.GeneratedValue;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;
import java.util.UUID;

@Data
public class BaseDTO {

    private Long id;
    private UUID uuid;
    private Date creationDate;
    private Date updatedDate;




}
