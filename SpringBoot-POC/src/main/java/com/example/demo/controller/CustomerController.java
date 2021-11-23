package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/api")

public class CustomerController {

	@Autowired
	CustomerService customerService;

	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomers() {

		return customerService.getAllCustomers();

	}

	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {
		return customerService.getCustomer(id);

	}

	@PostMapping("/customer")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {

		return customerService.saveCustomer(customer);

	}
	
	@PostMapping("/customers")
	public ResponseEntity<List<Customer>> saveCustomer(@RequestBody List<Customer> customers) {

		return customerService.saveCustomers(customers);

	}

	@PutMapping("/customers")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {

		return customerService.updateCustomer(customer);

	}

	@PatchMapping("/customers/{id}/{location}")
	public ResponseEntity<Customer> onlyUpdateCustomer(@PathVariable Long id, @PathVariable String location) {

		return customerService.onlyUpdateCustomer(id, location);

	}

	@DeleteMapping("/customers/{id}")
	public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable Long id) {

		return customerService.deleteCustomer(id);

	}
}