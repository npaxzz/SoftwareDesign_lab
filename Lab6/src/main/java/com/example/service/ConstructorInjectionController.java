package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Customer;

@RestController
@RequestMapping("/constructor")
public class ConstructorInjectionController {

	private CustomerService customerService;

	@Autowired
	public ConstructorInjectionController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping("/{id}") // http://localhost:8080/constructor/47
	public String getCustomer(@PathVariable Long id) {
		Customer cust = customerService.getCustomerById(id);
		return "Constructor Injection -> Customer ID : " + cust.getId() + ", Name : " + cust.getName();
	}

	@GetMapping("/customer/{id}/{name}") // http://localhost:8080/constructor/customer/04/Nattawadee
	public String getCustomer(@PathVariable Long id, @PathVariable String name) {
		Customer cust = customerService.getCustomerByIdName(id, name);
		return "Constructor Injection -> Customer ID : " + cust.getId() + ", Name : " + cust.getName();
	}
}
