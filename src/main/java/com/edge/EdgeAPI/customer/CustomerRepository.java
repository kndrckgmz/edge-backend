package com.edge.EdgeAPI.customer;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
    
    //SELECT * FROM customer WHERE email = ??
    // @Query("SELCET s FROM Customer s WHERE s.email = ??")
    Optional<Customer> findCustomerByEmail(String email);
}
