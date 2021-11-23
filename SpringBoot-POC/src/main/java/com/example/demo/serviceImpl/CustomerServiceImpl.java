package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.repository.ICustomerRepo;
import com.example.demo.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	ICustomerRepo customerRepo;

	@Override
	public ResponseEntity<List<Customer>> getAllCustomers() {
		try {
			List<Customer> list = customerRepo.findAll();

			if (list.isEmpty() || list.size() == 0) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Customer> getCustomer(Long id) {
		Optional<Customer> customer = customerRepo.findById(id);

		if (customer.isPresent()) {
			return new ResponseEntity<>(customer.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<Customer> saveCustomer(Customer customer) {
		try {

			return new ResponseEntity<>(customerRepo.save(customer), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Customer> updateCustomer(Customer customer) {
		try {
			return new ResponseEntity<>(customerRepo.save(customer), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Customer> onlyUpdateCustomer(Long id, String location) {
		try {

			Customer customer = customerRepo.findById(id).get();
			customer.setLocation(location);
			return new ResponseEntity<>(customerRepo.save(customer), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<HttpStatus> deleteCustomer(Long id) {
		try {
			Optional<Customer> customer = customerRepo.findById(id);
			if (customer.isPresent()) {
				customerRepo.delete(customer.get());
			}
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<List<Customer>> saveCustomers(List<Customer> customers) {
		try {
			return new ResponseEntity<>(customerRepo.saveAll(customers), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
