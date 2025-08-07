package com.example.model;

import org.springframework.stereotype.Component;

@Component
public class Customer {
	private Long id;
	private String name;

	// Constructor
	public Customer() {
	}

	public Customer(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	// Getting , Setter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return id + ":" + name;
	}

}
