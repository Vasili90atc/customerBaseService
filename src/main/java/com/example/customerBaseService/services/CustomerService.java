package com.example.customerBaseService.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.customerBaseService.models.Customer;
import com.example.customerBaseService.repositories.CustomerRepository;

@Service
public class CustomerService { 
	@Autowired
	private CustomerRepository customersRepository; 
	
	public Customer createNewCustomer(Customer customer) { 
		return customersRepository.save(customer); 
	}
	
	public List<Customer> getHead10Customers(){
		List<Customer> l = customersRepository.findAll();
		return l.subList(0, 10);
	}
	
	public List<Customer> getAllCustomers() { 
		return customersRepository.findAll(); 
	} 
	
	public Customer findCustomerByEmail(String email) { 
		return customersRepository.getByEmail(email); 
	}

}
