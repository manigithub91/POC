package com.example.demo.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Customer;

public interface CustomerService {
	public ResponseEntity<List<Customer>> getAllCustomers();

	public ResponseEntity<Customer> getCustomer(Long id);

	public ResponseEntity<Customer> saveCustomer(Customer customer);

	public ResponseEntity<Customer> updateCustomer(Customer customer);

	public ResponseEntity<Customer> onlyUpdateCustomer(Long id, String location);

	public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable Long id);

	public ResponseEntity<List<Customer>> saveCustomers(List<Customer> customers);

}
