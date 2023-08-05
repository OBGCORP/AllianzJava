package com.allianz.customerERP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CustomerErpApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerErpApplication.class, args);
    }

}
