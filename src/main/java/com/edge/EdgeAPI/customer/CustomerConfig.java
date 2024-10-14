package com.edge.EdgeAPI.customer;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {
    
    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository repository){
        return args -> {
            Customer kendrick = new Customer(
                1l,
                "Kendrick",
                "kendrickdgomez@gmail.com",
                LocalDate.of(2000, 6, 26)
            );

            Customer kevin = new Customer(
                "Kevin",
                "kevin@gmail.com",
                LocalDate.of(2000, 7, 14)
            );

            repository.saveAll(
                List.of(kendrick, kevin)
            );
        };
    }
}
