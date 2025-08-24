package com.customerapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customerapp.model.Customer;
import com.customerapp.repository.CustomerRepository;

import jakarta.transaction.Transactional;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository custRepo;

	public List<Customer> getCustomerList() {
		List<Customer> customers = (List<Customer>) custRepo.findAll();
		return customers;
	}

	public Customer getOneCustomerById(Long id) {
		return custRepo.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
	}

	@Transactional
	public void save(Customer customer) {
		custRepo.save(customer);
	}

	@Transactional
	public Customer addCustomer(Customer customer) {
		custRepo.save(customer);
		return customer;
	}

	@Transactional
	public Customer UpdateCustomer(Long id, Customer c) {
		Customer customer = custRepo.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
		customer.setId(id);
		customer.setName(c.getName());
		return custRepo.save(customer);
	}

	public void deleteCustomer(Long id) {
		Customer cust = custRepo.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
		custRepo.delete(cust);
	}
}
