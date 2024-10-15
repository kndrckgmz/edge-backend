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
                LocalDate.of(2000, 6, 26), 
                "kendrick@gmail.com", 
                "kendrick", 
                "test123"
            );

            Customer kevin = new Customer(
                null, 
                LocalDate.of(2000, 8, 5),
                "kev@gmail.com", 
                "kevin", 
                "test123"
            );

            Customer lyn = new Customer(
                null, 
                LocalDate.of(1996, 8, 5),
                "lyn@gmail.com", 
                "Lyn", 
                "test123"
            );

            repository.saveAll(
                List.of(kendrick, kevin, lyn)
            );
        };
    }
}
