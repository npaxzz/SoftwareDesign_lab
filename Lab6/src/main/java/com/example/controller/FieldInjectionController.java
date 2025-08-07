package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Customer;
import com.example.service.CustomerService;

@RestController
@RequestMapping("/field")
public class FieldInjectionController {

	@Autowired
	CustomerService customerService; // Filed Injection

	@GetMapping("/{id}") // http://localhost:8080/field/47
	public String getCustomer(@PathVariable Long id) {
		Customer cust = customerService.getCustomerById(id);
		return "Fild Injection -> Customer ID : " + cust.getId() + ", Name : " + cust.getName();
	}

	@GetMapping("/customer/{id}/{name}") // http://localhost:8080/field/customer/04/Nattawadee
	public String getCustomer(@PathVariable Long id, @PathVariable String name) {
		Customer cust = customerService.getCustomerByIdName(id, name);
		return "Fild Injection -> Customer ID : " + cust.getId() + ", Name : " + cust.getName();
	}

	@GetMapping("/customers") // http://localhost:8080/field/customers
	public List<Customer> getCustomer() {
		List<Customer> customers = new ArrayList<>();
		customers = customerService.getCustomerList();
		return customers;
	}
}
