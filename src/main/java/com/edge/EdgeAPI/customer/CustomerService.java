package com.edge.EdgeAPI.customer;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class CustomerService {

	private final CustomerRepository customerRepository;

	@Autowired
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}

	public void addNewCustomer(Customer customer) {

		Optional<Customer> customerOptional = customerRepository.findCustomerByEmail(customer.getEmail());
			
		if(customerOptional.isPresent()){
			throw new IllegalStateException("email already exists");
		}
		
		customerRepository.save(customer);
	}

	public void deleteCustomer(Long accountId){
		boolean exists = customerRepository.existsById(accountId);
		if (!exists){
			throw new IllegalStateException("customer with id " + accountId + " does not exist");
		}
		customerRepository.deleteById(accountId);
	}

	@Transactional
	public void updateCustomer(Long accountId, String name, String email){
		
		Customer customer = customerRepository.findById(accountId)
			.orElseThrow(() -> new IllegalStateException("customer with id " + accountId + " does not exist"));
		
		if (name != null && !Objects.equals(customer.getName(), name)) {
			customer.setName(name);
		}

		if (email != null && !Objects.equals(customer.getEmail(), email)){
			Optional<Customer> customerOptional = customerRepository.findCustomerByEmail(email);
			if (customerOptional.isPresent()){
				throw new IllegalStateException("email already exists");
			}
			customer.setEmail(email);
		}
	}
}