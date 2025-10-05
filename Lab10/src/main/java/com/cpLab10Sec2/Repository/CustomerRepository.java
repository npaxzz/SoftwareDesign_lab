package com.cpLab10Sec2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cpLab10Sec2.Entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
