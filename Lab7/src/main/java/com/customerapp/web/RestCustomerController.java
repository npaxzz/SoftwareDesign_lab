package com.customerapp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customerapp.model.Customer;
import com.customerapp.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class RestCustomerController {

	@Autowired
	private CustomerService custService;

	@GetMapping
	public ResponseEntity<List<Customer>> getCustomer() {
		List<Customer> customer = custService.getCustomerList();
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Customer> getOneCustomer(@PathVariable Long id) {
		Customer customer = custService.getOneCustomerById(id);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer cust) {
		Customer savedCustomer = custService.addCustomer(cust);
		return new ResponseEntity<>(savedCustomer, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Customer> UpdateCustomer(@PathVariable Long id, @RequestBody Customer cust) {
		Customer updateCustomer = custService.UpdateCustomer(id, cust);
		return new ResponseEntity<>(updateCustomer, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public void deleteCustomer(@PathVariable Long id) {
		custService.deleteCustomer(id);
	}

}