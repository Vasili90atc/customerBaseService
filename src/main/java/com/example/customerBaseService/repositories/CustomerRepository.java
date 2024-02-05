package com.example.customerBaseService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import com.example.customerBaseService.models.Customer;


import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
	public Customer findByEmail(String email); 
	public List<Customer> findByEmailTrue(); 
	public List<Customer> findByEmailFalse(); 
	public List<Customer> findAll();
	public Customer getByEmail(String Email);
}
