package com.edge.EdgeAPI.customer;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;
    
    // @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping
	public List<Customer> getCustomers() {
        return customerService.getCustomers();
	}

    @PostMapping
    public void registerNewCustomer(@RequestBody Customer customer){
        customerService.addNewCustomer(customer);
    }

    @DeleteMapping(path = "{accountId}")
    public void deleteCustomer(@PathVariable("accountId") Long accountId){
        customerService.deleteCustomer(accountId);
    }


    @PutMapping(path = "{accountId}")
    public void updateCustomer(
            @PathVariable("accountId") Long accountId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        //TODO: process PUT request
        customerService.updateCustomer(accountId, name, email);
    }
}