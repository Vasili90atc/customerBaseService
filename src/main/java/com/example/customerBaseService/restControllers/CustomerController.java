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
	public ResponseEntity<Customer> updateTask(@PathVariable String email) { 
		return ResponseEntity.ok(customerService.findCustomerByEmail(email)); 
	}  
}