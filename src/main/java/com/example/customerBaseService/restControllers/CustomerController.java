package com.example.customerBaseService.restControllers;

import org.springframework.beans.factory.annotation.Autowired; 

import org.springframework.http.ResponseEntity; 
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.*;

import com.example.customerBaseService.models.Customer;
import com.example.customerBaseService.services.CustomerService;

import java.util.List; 

@Controller
@RequestMapping("/api/v1/customers") 
public class CustomerController { 

	@Autowired
	private CustomerService customerService; 
	
	@GetMapping("/") 
	public ResponseEntity<List<Customer>> getAllCustomers() { 
		return ResponseEntity.ok(customerService.getHead10Customers()); 
	}
	@GetMapping("/{email}") 
	public ResponseEntity<Customer> getCustomer(@PathVariable String email) { 
		return ResponseEntity.ok(customerService.findCustomerByEmail(email)); 
	}
	@PutMapping("/{email}") 
	public ResponseEntity<Customer> updateCustomer(@PathVariable String email, @RequestBody Customer customer) { 
		customer.setEmail(email); 
		return ResponseEntity.ok(customerService.updateCustomer(customer)); 
	} 
	@DeleteMapping("/{email}") 
	public ResponseEntity<Boolean> deleteCustomer(@PathVariable String email) { 
		customerService.deleteCustomer(email); 
		return ResponseEntity.ok(true); 
	}
	@PostMapping("/") 
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		System.out.println(customer);
		return ResponseEntity.ok(customerService.createNewCustomer(customer)); 
	} 
}