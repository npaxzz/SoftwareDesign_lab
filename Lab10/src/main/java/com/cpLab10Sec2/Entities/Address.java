package com.cpLab10Sec2.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "addresses", uniqueConstraints = @UniqueConstraint(name = "uk_addresses_customer", columnNames = "customer_id"))
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 120)
	private String line1;
	@Size(max = 120)
	private String line2;
	@NotBlank
	@Size(max = 80)
	private String city;
	@Size(max = 80)
	private String state;
	@Size(max = 20)
	private String postalCode;
	@Size(max = 80)
	private String country;

	@OneToOne
	@JoinColumn(name = "customer_id", nullable = false, unique = true, foreignKey = @ForeignKey(name = "fk_addresses_customer"))
	private Customer customer;

	void setCustomer(Customer customer) {
		this.customer = customer;
	} // keep package-private

	// getters/setters ...
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	Customer getCustomer() {
		return customer;
	}
}
